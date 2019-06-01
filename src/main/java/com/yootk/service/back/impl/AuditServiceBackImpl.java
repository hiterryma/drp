package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.*;
import com.yootk.service.back.IAuditServiceBack;
import com.yootk.vo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuditServiceBackImpl extends AbstractService implements IAuditServiceBack {
    @Autowired
    private IStorage_applyDAO storage_applyDAO ;
    @Autowired
    private IStorage_apply_detailsDAO storage_apply_detailsDAO ;
    @Autowired
    private IWarehouseDAO warehouseDAO ;
    @Autowired
    private IWitemDAO witemDAO ;
    @Autowired
    private IMemberDAO memberDAO ;
    @Autowired
    private IAuditDAO auditDAO ;
    @Autowired
    private IGoodsDAO goodsDAO ;


    @Override
    public Map<String, Object> preAdd(Long said) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        //保存单价的Map
        Map<Long,Double> pricemap = new HashMap<>() ;
        //保存重量的Map
        Map<Long,Double> weightmap = new HashMap<>() ;
        //根据清单编号查询该清单所有信息
        Storage_apply storage_apply = storage_applyDAO.findById(said) ;
        Long wid = storage_apply.getWid() ;
        Warehouse warehouse = warehouseDAO.findById(wid) ;
        //记录仓库地址+仓库名称
        String title = warehouse.getAddress() + "     " + warehouse.getName() ;

        //找到该清单对应的仓库类型数据
        Long wiid = storage_apply.getWiid() ;
        Witem witem = witemDAO.findById(wiid) ;

        //找到该清单申请人的信息
        Member member = this.memberDAO.findById(storage_apply.getMid()) ;

        //定义一个Map保存总价
        Map<Long,Double> totalmap = new HashMap<>() ;
        //定义一个Map保存审核信息
        Map<Long,String> auditnotemap = new HashMap<>() ;
        //保存清单总价
        Double totalprice = 0.0;

        //获取该清单的所有审核信息
        List<Audit> allAudit = new ArrayList<>() ;
        try {
            System.out.println(said);
            System.out.println(this.auditDAO.findAllBySaid(said));
            allAudit = this.auditDAO.findAllBySaid(said) ;
        }catch (Exception e) {
            e.printStackTrace();
        }




        List<Storage_apply_details> allStorage_apply_details = this.storage_apply_detailsDAO.findAllBySaid(said) ;
        for (Storage_apply_details storage_apply_details : allStorage_apply_details) {
            Goods goods = this.goodsDAO.findById(storage_apply_details.getGid()) ;
            pricemap.put(storage_apply_details.getSadid(),goods.getPrice()) ;
            weightmap.put(storage_apply_details.getSadid(),goods.getWeight()) ;
            totalprice += storage_apply_details.getPrice() ;
        }
        result.put("storage_apply",storage_apply) ;
        result.put("title",title) ;
        result.put("witem",witem) ;
        result.put("pricemap",pricemap) ;
        result.put("weightmap",weightmap) ;
        result.put("member",member) ;
        result.put("totalprice",totalprice) ;
        result.put("allAudit",allAudit) ;
        result.put("warehouse",warehouse) ;
        //存放Storage_apply_details的List集合
        result.put("allStorage_apply_details",allStorage_apply_details) ;
        return result ;
    }

    @Override
    public boolean audit(Long said, Audit audit) throws Exception {
        Storage_apply storage_apply = this.storage_applyDAO.findById(said) ;
        storage_apply.setAudit_status(1);
        if (this.storage_applyDAO.doEdit(storage_apply) && this.auditDAO.doCreate(audit)) {
            return true ;
        }
        return false ;
    }

    @Override
    public boolean preSearch(Long said) throws Exception {
        return false;
    }

}
