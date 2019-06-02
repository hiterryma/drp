package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IGoodsDAO;
import com.yootk.dao.IShopcarDAO;
import com.yootk.service.front.IShopcarServiceFront;
import com.yootk.vo.Goods;
import com.yootk.vo.Shopcar;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service //注解业务层
public class ShopcarServiceFrontImpl extends AbstractService implements IShopcarServiceFront {
    @Autowired //自动注入
    private IShopcarDAO shopcarDAO;
    @Autowired
    private IGoodsDAO goodsDAO ;
    @Override
    public boolean add(Shopcar vo) throws Exception {
        //1.根据用户id和商品编号查询已有的购物车中的保存的商品数量
        Integer amout=this.shopcarDAO.findAmountByMemberAndGoods(vo.getMid(),vo.getGid());
        if(amout==null){    //此时还没有相应的购物数据的存储
            vo.setAmount(1);//假设现在追加一次
            return this.shopcarDAO.doCreate(vo);//2.保存一条新的记录
        }else{
            //3.如果此时的amount已经存在
            amout++;
            return this.shopcarDAO.doEditAmountByMemberAndGoods(vo.getMid(),vo.getGid(),amout);
        }

    }

    @Override
    public Map<String, Object> listByMember(String mid) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        Map<Long,Integer> shopcar = this.shopcarDAO.findAllByMember(mid) ;
        List<Goods> allGoods = this.goodsDAO.findAllByGids(shopcar.keySet()) ;
        result.put("shopcar",shopcar) ;
        result.put("allGoods",allGoods) ;
        return result;
    }

    @Override
    public boolean editBatch(List<Shopcar> cars) throws Exception {
        if(cars==null||cars.size()==0){
            return false;//不进行内容的修改
        }
        return this.shopcarDAO.doEditBatch(cars);
    }

    @Override
    public boolean deleteByMember(String mid, Set<Long> gids) throws Exception {
        if(gids==null||gids.size()==0){
            return false;
        }
        return this.shopcarDAO.doRemoveByMemberAndGoods(mid,gids);
    }

    @Override
    public Integer findAmount(String mid, Long gid) throws SQLException {
        return this.shopcarDAO.findAmountByMemberAndGoods(mid,gid);
    }
}
