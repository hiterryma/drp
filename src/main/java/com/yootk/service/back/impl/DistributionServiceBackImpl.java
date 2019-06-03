package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.*;
import com.yootk.service.back.IDistributionServiceBack;
import com.yootk.vo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DistributionServiceBackImpl extends AbstractService implements IDistributionServiceBack {
    @Autowired
    private IDistribution_memberDAO distribution_memberDAO ;
    @Autowired
    private ICustomerDAO customerDAO ;
    @Autowired
    private IDistribution_member_goodsDAO distribution_member_goodsDAO ;
    @Autowired
    private IGoodsDAO goodsDAO ;
    @Autowired
    private ICitemDAO citemDAO ;
    @Override
    public Map<String, Object> preAdd(String salemid) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        List<Distribution_member> allDistribution_members = this.distribution_memberDAO.findAllBysalemid(salemid) ;
        //查询编号最大的那个
        if (allDistribution_members.size() != 0) {
            Long dmid = 0L ;
            for (Distribution_member distribution_member : allDistribution_members) {
                if (dmid < distribution_member.getDmid()) {
                    dmid = distribution_member.getDmid() ;
                }
            }
            //查询到要找的出库客户信息
            Distribution_member distribution_member = this.distribution_memberDAO.findById(dmid) ;
            //1、找到客户信息
            Customer customer = this.customerDAO.findById(distribution_member.getCuid()) ;
            Citem citem = this.citemDAO.findById(customer.getCiid()) ;
            //2、查询出该出库所要的所有商品
            List<Distribution_member_goods> allDistribution_member_goods = this.distribution_member_goodsDAO.findAllByDmid(dmid) ;
            //3、查到所有商品的具体信息
            List<Goods> allGoods = new ArrayList<>() ;
            for (Distribution_member_goods distribution_member_goods : allDistribution_member_goods) {
                allGoods.add(this.goodsDAO.findById(distribution_member_goods.getGid())) ;
            }


            //进行存放
            result.put("customer",customer) ;
            result.put("citem",citem) ;
            result.put("allGoods",allGoods) ;
            System.out.println(result);

        }
        return result ;

    }
}
