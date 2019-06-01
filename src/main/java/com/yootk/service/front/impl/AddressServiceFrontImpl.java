package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IAddressDAO;
import com.yootk.dao.ICityDAO;
import com.yootk.dao.IProvinceDAO;
import com.yootk.service.front.IAddressServiceFront;
import com.yootk.vo.Address;
import com.yootk.vo.Province;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class AddressServiceFrontImpl extends AbstractService implements IAddressServiceFront {
    @Autowired
    private IAddressDAO addressDAO;    //查询所有的地址
    @Autowired
    private IProvinceDAO provinceDAO; // 查询所有的省份
    @Autowired
    private ICityDAO cityDAO ;     //查询所有的城市

    @Override
    public boolean add(Address address) throws Exception {
        return this.addressDAO.doCreate(address);
    }

    public Map<String, Object> preAdd() throws Exception {
        Map<String ,Object> result =new HashMap<>() ;
        List<Province> allProvinces =this.provinceDAO.findAll() ; // 查询所有的省份
        result.put("allProvinces",allProvinces) ;
        return result;
    }

    @Override
    public Map<String ,Object> list(String mid) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>() ;
        map.put("allAddresses",this.addressDAO.findAll(mid));
        return map;

    }

    @Override
    public boolean deleteByAddress(String mid, Set<Long> adids) throws SQLException {
        if (adids == null || adids.size() == 0) {
            return false ;
        }
        return this.addressDAO.doRemoveByAddress(mid,adids);
    }

    @Override
    public boolean edit(Address address) throws SQLException {
        return this.addressDAO.doEdit(address);
    }

    @Override
    public Map<String,Object> preEdit() throws Exception {
        Map<String ,Object> result =new HashMap<>() ;
        List<Province> allProvinces =this.provinceDAO.findAll() ; // 查询所有的省份
        result.put("allProvinces",allProvinces) ;
        return result;
    }

}
