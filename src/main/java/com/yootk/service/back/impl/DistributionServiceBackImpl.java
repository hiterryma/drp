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
    @Autowired
    private IProvinceDAO provinceDAO ;
    @Autowired
    private ICityDAO cityDAO ;
    @Autowired
    private IMemberDAO memberDAO ;
    @Override
    public Map<String, Object> preAdd(String salemid) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
//        List<Distribution_member> allDistribution_members = this.distribution_memberDAO.findAllBysalemid(salemid) ;
//        //查询编号最大的那个
//        if (allDistribution_members.size() != 0) {
//            Long dmid = 0L ;
//            for (Distribution_member distribution_member : allDistribution_members) {
//                if (dmid < distribution_member.getDmid()) {
//                    dmid = distribution_member.getDmid() ;
//                }
//            }
        Member member = this.memberDAO.findById(salemid) ;


//        //查询到要找的出库客户信息
//        Distribution_member distribution_member = this.distribution_memberDAO.findById(dmid) ;
        //1、找到客户信息
        Customer customer = this.customerDAO.findById(member.getCuid()) ;
        Citem citem = this.citemDAO.findById(customer.getCiid()) ;
        //2、从该客户出库意向中查询出编号最大的那个
        List<Distribution_member> allDistribution_members = this.distribution_memberDAO.findAllByCuid(customer.getCuid()) ;
        //查询编号最大的那个
        if (allDistribution_members.size() != 0) {
            Long dmid = 0L;
            for (Distribution_member distribution_member : allDistribution_members) {
                if (dmid < distribution_member.getDmid()) {
                    dmid = distribution_member.getDmid();
                }
            }
            //2、查询出该出库所要的所有商品
            List<Distribution_member_goods> allDistribution_member_goods = this.distribution_member_goodsDAO.findAllByDmid(dmid);
            //3、查到所有商品的具体信息
            List<Goods> allGoods = new ArrayList<>();
            for (Distribution_member_goods distribution_member_goods : allDistribution_member_goods) {
                allGoods.add(this.goodsDAO.findById(distribution_member_goods.getGid()));
            }
            result.put("allGoods",allGoods) ;
        }



        //进行存放
        result.put("customer",customer) ;
        result.put("citem",citem) ;

        System.out.println(result);


        return result ;

    }

    public Map<String,Object> showPC(Long cuid) throws Exception {
        System.out.println(cuid);
        Map<String,Object> result = new HashMap<>() ;
        Customer customer = this.customerDAO.findById(cuid) ;
        Province province = this.provinceDAO.findById(customer.getPid()) ;
        City city = this.cityDAO.findById(customer.getCid()) ;
        result.put("province",province) ;
        result.put("city",city) ;
        System.out.println(result);
        return result ;

    }


}
