package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IDeptDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.service.back.IDeptService;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeptServiceImpl extends AbstractService implements IDeptService {

    @Autowired
    private IDeptDAO deptDAO;
    @Autowired
    private IMemberDAO memberDAO;

    @Override
    public Map<String, Object> listDeptMember() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("allDepts", deptDAO.findAll());
        return map;
    }
}
