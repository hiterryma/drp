package com.yootk.service.pub.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.ICityDAO;
import com.yootk.service.pub.ICityService;
import com.yootk.vo.City;

import java.util.List;
@Service
public class CityServiceImpl extends AbstractService implements ICityService {

    @Autowired
    private ICityDAO cityDAO;

    @Override
    public List<City> listByProvince(Long pid) throws Exception {
        return cityDAO.findAllByProvince(pid);
    }
}
