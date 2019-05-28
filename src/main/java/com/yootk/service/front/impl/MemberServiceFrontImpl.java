package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IMemberDAO;
import com.yootk.service.front.IMemberServiceFront;
import com.yootk.vo.Member;

@Service
public class MemberServiceFrontImpl extends AbstractService implements IMemberServiceFront {
    @Autowired
    private IMemberDAO memberDAO;

    @Override
    public boolean findById(String mid) throws Exception {
        String cmid = this.memberDAO.findMemberById(mid);
        if (cmid != null){  //用户的id存在
            return false;
        }
        //不存返回true
        return true;
    }

    @Override
    public Integer access_right(String mid) throws Exception {
        return this.memberDAO.findByDeptAndMember(mid);
    }

    @Override
    public boolean register(Member vo) throws Exception {
        return this.memberDAO.doCreateByMember(vo);
    }

    @Override
    public boolean login(Member vo) throws Exception {
        Member member = this.memberDAO.findByIdAndpw(vo.getMid());
        if (member == null) {
            return false;
        }
        else {
            return member.getPassword().equals(vo.getPassword());
        }
    }
}
