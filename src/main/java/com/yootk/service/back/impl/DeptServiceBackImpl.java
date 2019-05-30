package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IDeptDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.service.back.IDeptServiceBack;
import com.yootk.vo.Dept;

import java.util.HashMap;
import java.util.Map;
@Service
public class DeptServiceBackImpl extends AbstractService implements IDeptServiceBack {
    @Autowired
    private IDeptDAO deptDAO ;
    @Autowired
    private IMemberDAO memberDAO ;
    @Override
    public boolean edit(Dept dept) throws Exception {
        return this.deptDAO.doEdit(dept);
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("allDepts",this.deptDAO.findSplit(currentPage,lineSize));
        System.out.println(this.memberDAO.findAllMap());
        map.put("allMembers",this.memberDAO.findAllMap()) ;
        return map;
    }
}
