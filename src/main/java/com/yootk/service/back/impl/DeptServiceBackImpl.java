package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IDeptDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.service.back.IDeptServiceBack;
import com.yootk.vo.Dept;
import com.yootk.vo.Member;

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
        Map<String, String> allMemberMap = new HashMap<>();
        for (Member member:memberDAO.findAll()) {
            allMemberMap.put(member.getMid(), member.getName());
        }
        map.put("allMemberMap",allMemberMap) ;
        map.put("allDepts",this.deptDAO.findSplit(currentPage,lineSize));
        return map;
    }
}
