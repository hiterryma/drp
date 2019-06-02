package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.*;
import com.yootk.service.back.IStorage_recordServiceBack;
import com.yootk.vo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class Storage_recordServiceBackImpl extends AbstractService implements IStorage_recordServiceBack {
    @Autowired
    private IAuditDAO auditDAO ;
    @Autowired
    private IStorage_applyDAO storage_applyDAO ;
    @Autowired
    private IWarehouseDAO warehouseDAO ;
    @Autowired
    private IWitemDAO witemDAO ;
    @Autowired
    private IStorage_apply_detailsDAO storage_apply_detailsDAO ;
    @Autowired
    private IGoodsDAO goodsDAO ;

    @Override
    public Map<String,Object> preSearch(Long said) throws Exception {
        List<Audit> auditList = this.auditDAO.findAllBySaid(said) ;
        Map<String,Object> result = new HashMap<>() ;
        if (auditList.size() != 0) {
            Long auditid = 0L ;
            for (Audit audit : auditList){
                if (auditid < audit.getAudid()){
                    auditid = audit.getAudid() ;
                }
            }
            Audit auditLast = this.auditDAO.findById(auditid) ;
            said = auditLast.getSaid() ;
            //保存单价的Map
            Map<Long,Double> pricemap = new HashMap<>() ;
            //保存重量的Map
            Map<Long,Double> weightmap = new HashMap<>() ;
            //根据清单编号查询该清单所有信息
            Storage_apply storage_apply = storage_applyDAO.findById(said) ;
            Long wid = storage_apply.getWid() ;
            Long wiid = storage_apply.getWiid() ;
            //找到清单对应的所有仓库数据
            Warehouse warehouse = warehouseDAO.findById(wid) ;

            //记录仓库地址+仓库名称
            String title = warehouse.getAddress() + "     " + warehouse.getName() ;
            //找到所有的仓库类型数据
            Witem witem = witemDAO.findById(wiid) ;

            List<Storage_apply_details> allStorage_apply_details = this.storage_apply_detailsDAO.findAllBySaid(said) ;
            for (Storage_apply_details storage_apply_details : allStorage_apply_details) {
                Goods goods = this.goodsDAO.findById(storage_apply_details.getGid()) ;
                pricemap.put(storage_apply_details.getSadid(),goods.getPrice()) ;
                weightmap.put(storage_apply_details.getSadid(),goods.getWeight()) ;
            }
            result.put("storage_apply",storage_apply) ;
            result.put("title",title) ;
            result.put("witem",witem) ;
            result.put("pricemap",pricemap) ;
            result.put("weightmap",weightmap) ;
            //存放Storage_apply_details的List集合
            result.put("allStorage_apply_details",allStorage_apply_details) ;
            return result ;
        }
        return null ;
    }
}
