package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.ICityDAO;
import com.yootk.dao.IProvinceDAO;
import com.yootk.service.front.IProvinceServiceFront;
import com.yootk.vo.Province;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProvinceServiceFrontImpl extends AbstractService implements IProvinceServiceFront {


    public Map<String, Object> preAdd() throws Exception {

        return null;
    }
}
