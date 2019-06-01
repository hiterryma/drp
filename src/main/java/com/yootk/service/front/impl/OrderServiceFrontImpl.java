package com.yootk.service.front.impl;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.*;
import com.yootk.dao.impl.DetailsDAOImpl;
import com.yootk.service.front.IOrderServiceFront;
import com.yootk.vo.*;

import java.util.*;

@Service
public class OrderServiceFrontImpl extends AbstractService implements IOrderServiceFront {
    @Autowired
    private IDetailsDAO detailsDAO;
    @Autowired
    private IOrdersDAO ordersDAO;
    @Autowired
    private IShopcarDAO shopcarDAO;//查询购物车
    @Autowired
    private IGoodsDAO goodsDAO;//查询商品
    @Autowired
    private IProvinceDAO provinceDAO;//查询所有的省份
    @Autowired
    private IAddressDAO addressDAO;

    @Override
    public Map<String, Object> getDetails(Long oid) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        map.put("orders",this.ordersDAO.findById(oid)) ;
        Map<Long,Integer> details = this.detailsDAO.findAllByOrders(oid) ;
        map.put("details",details) ;
        map.put("allGoods",this.goodsDAO.findAllByGids(details.keySet())) ;
        map.put("address",this.addressDAO.findById(new Long(this.ordersDAO.findById(oid).getAdid())));
        return map;
    }

    @Override
    public Map<String, Object> list(String mid, Long currentPage, Integer lineSize) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        map.put("allOrders",this.ordersDAO.findSplitByMember(mid,currentPage,lineSize)) ;
        map.put("allRecorders",this.ordersDAO.getAllCountByMember(mid)) ;
        return map ;
    }

    @Override
    public Map<String, Object> preAdd(String mid, Set<Long> gids) throws Exception {
        Map<String,Object> result=new HashMap<>();
        Map<Long,Integer> shopcar=this.shopcarDAO.findAllByMember(mid);//列出购物车的全部信息
        List<Goods> allGoods=this.goodsDAO.findAllByGids(gids); //列出所有的商品信息
        List<Province> allProvinces=this.provinceDAO.findAll(); //列出所有省份数据
        result.put("shopcar",shopcar);
        result.put("allGoods",allGoods);
        result.put("allProvinces",allProvinces);
        return  result;
    }
    @Override
    public boolean add(String aid, Set<Long> gids, String note) throws Exception {
       if(this.ordersDAO.doCreate(aid,gids,note)){  //如果创建订单成功
           List<Details> allDetails=new ArrayList<>();
           Long oid=this.ordersDAO.findLastId();//获取当前订单的id
           IDetailsDAO detailsDAO=new DetailsDAOImpl();
           for(Long gid:gids){  //创建订单详情内容
               Details det=new Details();
               det.setOid(oid);//保存订单编号
               det.setGid(gid);//保存订单商品编号
               //查找shopcar中对应gid的商品数量
               Integer amount=this.shopcarDAO.findAmountByMemberAndGoods(AbstractAction.getFrontUser(),gid);
               det.setAmount(amount);//获取商品数量
               allDetails.add(det);
           }
           if(detailsDAO.doCreateBatch(allDetails)){  //订单详情保存成功
               //Orders orders=new Orders();
               //6.删除购物车中的相应数据
               this.shopcarDAO.doRemoveByMemberAndGoods(AbstractAction.getFrontUser(),gids);
               return true;
           }
           return false;
       }
        return false;
    }

    @Override
    public boolean addDetails(Set<Long> gids) throws Exception {
        return false;
    }

    @Override
    public List<Address> findAllAdress() throws Exception {
        return this.addressDAO.findAll();
    }

    @Override
    public boolean add(Orders orders, Set<Long> gids) throws Exception {
        //1.将当前的日期设置为订单的创建日期
        orders.setSubdate(new Date());   //将当前日期设置为下单日期
        double sum=0.0;//进行商品总价的保存
        //2.获取订单对应的所有商品数据，利用商品数据可以计算总价
        List<Goods> allGoods=this.goodsDAO.findAllByGids(gids);
        Map<Long,Integer> shopcar=this.shopcarDAO.findAllByMember(orders.getMid());//获取当前用户的购物车内容
        for(Goods goods:allGoods){
            sum+=goods.getPrice()*shopcar.get(goods.getGid());//商品单价*商品数量
        }
        //3.将总价的信息保存在Orders对象之中
        orders.setPrice(sum);
        //4.进行订单的数据存储
        if(this.ordersDAO.doCreate(orders)){  //创建订单
            Long oid=this.ordersDAO.findLastId();//获取当前订单的id
            List<Details> allDetails=new ArrayList<>();
            for(Long gid:gids){  //创建订单详情内容
                Details det=new Details();
                det.setOid(oid);//保存订单编号
                det.setGid(gid);//保存订单商品编号
                det.setAmount(shopcar.get(gid));//获取商品数量
                allDetails.add(det);
            }
            //5.将所有的订单详情的内容进行存储
            if(this.detailsDAO.doCreateBatch(allDetails)){  //订单详情保存成功
                //6.删除购物车中的相应数据
                return this.shopcarDAO.doRemoveByMemberAndGoods(orders.getMid(),gids);
            }
        }
        return false;
    }


}
