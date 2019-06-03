package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IActionDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.dao.IRoleDAO;
import com.yootk.service.front.IRoleServiceFront;
import com.yootk.vo.Member;

import java.util.HashMap;
import java.util.Map;

@Service
public class RoleServiceFront extends AbstractService implements IRoleServiceFront {
    @Autowired
    private IRoleDAO roleDAO;
    @Autowired
    private IActionDAO actionDAO;
    @Autowired
    private IMemberDAO memberDAO;

    @Override
    public Member getByMid(String mid) throws Exception {
        return this.memberDAO.findDidByDeptAndMember(mid);
    }

    @Override
    public Map<String, Object> role_action(String mid) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        Member vo = this.memberDAO.findDidByDeptAndMember(mid);
        map.put("allActions",this.actionDAO.findAllByMember(vo.getDid()));
        map.put("allRoles",this.roleDAO.findAllByMember(vo.getDid()));
        map.put("did",vo.getDid());
        map.put("name",vo.getName()) ;
        return map;
    }
}
