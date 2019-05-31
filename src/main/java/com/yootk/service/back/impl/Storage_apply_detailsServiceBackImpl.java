package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IStorage_applyDAO;
import com.yootk.dao.IStorage_apply_detailsDAO;
import com.yootk.dao.IWarehouseDAO;
import com.yootk.dao.IWitemDAO;
import com.yootk.service.back.IStorage_apply_detailsServiceBack;
import com.yootk.vo.Storage_apply;
import com.yootk.vo.Warehouse;
import com.yootk.vo.Witem;

import java.util.HashMap;
import java.util.Map;
@Service
public class Storage_apply_detailsServiceBackImpl extends AbstractService implements IStorage_apply_detailsServiceBack {
    @Autowired
    private IStorage_applyDAO storage_applyDAO ;
    @Autowired
    private IWarehouseDAO warehouseDAO ;
    @Autowired
    private IWitemDAO witemDAO ;
    @Autowired
    private IStorage_apply_detailsDAO storage_apply_detailsDAO ;
    @Override
    public Map<String, Object> preAdd(Long said) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        Storage_apply storage_apply = storage_applyDAO.findById(said) ;
        Long wid = storage_apply.getWid() ;
        Long wiid = storage_apply.getWiid() ;
        Warehouse warehouse = warehouseDAO.findById(wid) ;
        //记录仓库地址+仓库名称
        String title = warehouse.getAddress() + "     " + warehouse.getName() ;
        Witem witem = witemDAO.findById(wiid) ;
        result.put("storage_apply",storage_apply) ;
        result.put("title",title) ;
        result.put("witem",witem) ;
        //存放Storage_apply_details的List集合
        result.put("allStorage_apply_details",this.storage_apply_detailsDAO.findAllBySaid(said)) ;
        return result ;
    }
}
