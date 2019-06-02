package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.encrypt.EncryptUtil;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IActionDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.dao.IRoleDAO;
import com.yootk.service.front.IMemberServiceFront;
import com.yootk.vo.Member;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberServiceFrontImpl extends AbstractService implements IMemberServiceFront {
    @Autowired
    private IMemberDAO memberDAO;
    @Autowired
    private IActionDAO actionDAO ;
    @Autowired
    private IRoleDAO roleDAO ;
    @Override
    public boolean update_password(String oldpassword,String newpassword,String mid) throws Exception {
        Member vo = this.memberDAO.findByIdAndpw(mid);
        if (EncryptUtil.encode(oldpassword).equals(vo.getPassword())) {
            return this.memberDAO.doEditPasswordByMember(EncryptUtil.encode(newpassword),mid);
        }
        return false;
    }

    @Override
    public boolean update_personalData(Member vo) throws Exception {
        return this.memberDAO.doEditDatumByMember(vo);
    }

    @Override
    public Member findBy_personalData(String mid) throws Exception {
        return this.memberDAO.findDatumByMember(mid);
    }

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
        return this.memberDAO.findTypeByMember(mid);
    }

    @Override
    public boolean add_register(Member vo) throws Exception {
        return this.memberDAO.doCreateByMember(vo);
    }

    @Override
    public Map<String,Object> login(Member vo) throws Exception {
        Member member = this.memberDAO.findById(vo.getMid());
        Map<String,Object> map = new HashMap<>() ;
        if (member != null) {
            this.memberDAO.update_lastTinme(vo);
           map.put("flag",member.getPassword().equals(vo.getPassword()))  ;
           map.put("allActions",actionDAO.findAllByMember(member.getDid())) ;
           map.put("did",member.getDid());
           map.put("allRoles",roleDAO.findAllByMember(member.getDid()));
           map.put("name",member.getName()) ;
        }else {
            map.put("flag",false);
        }
        return map;
    }
}
