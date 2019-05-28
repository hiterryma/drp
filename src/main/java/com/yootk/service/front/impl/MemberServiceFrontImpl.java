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
    private IMemberDAO memberDAO ;

    @Override
    public Integer access_right(String mid) throws Exception {
        if (mid != null){
            return this.memberDAO.findByDeptAndMember(mid);
        }
        return 0;
    }

    @Override
    public boolean register(Member vo) throws Exception {
        if (vo != null){
            return  this.memberDAO.doCreateByMember(vo);
        }
        return false;
    }

    @Override
    public boolean login(Member vo) throws Exception {
        Member member = this.memberDAO.findByIdAndpw(vo.getMid());
        if (member != null){
            return member.getPassword().equals(vo.getPassword());
        }
        return false;
    }
}
