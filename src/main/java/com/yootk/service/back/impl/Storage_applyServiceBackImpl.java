package com.yootk.service.back.impl;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.ICityDAO;
import com.yootk.dao.IProvinceDAO;
import com.yootk.dao.IStorage_applyDAO;
import com.yootk.dao.IWitemDAO;
import com.yootk.service.back.IStorage_applyServiceBack;
import com.yootk.vo.City;
import com.yootk.vo.Province;
import com.yootk.vo.Storage_apply;
import com.yootk.vo.Witem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class Storage_applyServiceBackImpl extends AbstractService implements IStorage_applyServiceBack {
    @Autowired
    private IProvinceDAO provinceDAO;
    @Autowired
    private IWitemDAO witemDAO ;
    @Autowired
    private IStorage_applyDAO storage_applyDAO ;
    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        List<Province> allProvinces = this.provinceDAO.findAll() ;
        List<Witem> allWitems = this.witemDAO.findAll() ;
        result.put("allProvinces",allProvinces) ;
        result.put("allWitems",allWitems) ;
        return result ;
    }

    @Override
    public boolean add(Storage_apply storage_apply) throws Exception {
        return this.storage_applyDAO.doCreate(storage_apply) ;
    }
}
