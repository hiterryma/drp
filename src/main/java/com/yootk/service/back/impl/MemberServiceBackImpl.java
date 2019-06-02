package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.encrypt.EncryptUtil;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IDeptDAO;
import com.yootk.dao.ILevelDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.service.back.IMemberServiceBack;
import com.yootk.vo.Dept;
import com.yootk.vo.Level;
import com.yootk.vo.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MemberServiceBackImpl extends AbstractService implements IMemberServiceBack {
    @Autowired
    private IMemberDAO memberDAO ;
    @Autowired
    private IDeptDAO deptDAO ;
    @Autowired
    private ILevelDAO levelDAO ;
    @Override
    public boolean add(Member member) throws Exception {
        if(member.getPassword() != null){
            member.setPassword(EncryptUtil.encode(member.getPassword())) ;
        }
        //如果当选用户职位类型为经理，则并更新为当前用户
        if(member.getLid().equals("2")){
           Dept dept  =  this.deptDAO.findById(member.getDid());
           dept.setMid(member.getMid());
           this.deptDAO.doEdit(dept);
        }
        return this.memberDAO.doCreate(member) ;
    }

    @Override
    public boolean edit(Member member) throws Exception {
        if(member.getPassword()==null || "".equals(member.getPassword())){
            member.setPassword(this.memberDAO.findById(member.getMid()).getPassword());
        }else{
            member.setPassword(EncryptUtil.encode(member.getPassword())) ;
        }

        if(member.getPhoto()==null || "".equals(member.getPhoto())){
            member.setPhoto(this.memberDAO.findById(member.getMid()).getPhoto());
        }
        return this.memberDAO.doEdit(member) ;
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<>() ;
        if(isEmpty(column,keyword)){
            map.put("allMembers",this.memberDAO.findSplit(currentPage,lineSize)) ;
            map.put("allRecorders",this.memberDAO.getAllCount()) ;
        }else {
            map.put("allMembers",this.memberDAO.findSplit(currentPage,lineSize,column,keyword)) ;
            map.put("allRecorders",this.memberDAO.getAllCount(column,keyword)) ;
        }
        Map<Long,String> allLevelMap = new HashMap<>();
        for (Level level :this.levelDAO.findAll()){
            allLevelMap.put(level.getLid(),level.getTitle());
        }
        Map<Long,String> allDeptMap= new HashMap<>();
        for (Dept dept :this.deptDAO.findAll()){
            allDeptMap.put(dept.getDid(),dept.getDname());
        }
        map.put("allDepts",allDeptMap) ;
        map.put("allLevels",allLevelMap) ;
        return map;
    }

    @Override
    public Member get(String mid) throws Exception {
        Member member = this.memberDAO.findById(mid) ;

        return member;
    }

    @Override
    public boolean delete(Set<String> mids) throws Exception {
        return this.memberDAO.doRemove(mids) ;
    }

    @Override
    public Map<String, Object> preEdit(String mid) throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        map.put("member",this.memberDAO.findById(mid)) ;
        List<Dept> deptList = this.deptDAO.findAll() ;
        List<Level> levelList = this.levelDAO.findAll() ;
        Map<String,String> allLevelMap = new HashMap<>();
        for (Level level :levelList){
            allLevelMap.put(level.getLid().toString(),level.getTitle());
        }
        Map<String,String> allDeptMap= new HashMap<>();
        for (Dept dept :deptList){
            allDeptMap.put(dept.getDid().toString(),dept.getDname());
        }
        map.put("allDepts",deptList) ;
        map.put("allLevels",levelList) ;
        map.put("allDeptMap",allDeptMap) ;
        map.put("allLevelMap",allLevelMap) ;
        return map;
    }
    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String,Object> map = new HashMap<>() ;
        List<Dept> deptList = this.deptDAO.findAll() ;
        List<Level> levelList = this.levelDAO.findAll() ;
        Map<String,String> allLevelMap = new HashMap<>();
        for (Level level :levelList){
            allLevelMap.put(level.getLid().toString(),level.getTitle());
        }
        Map<String,String> allDeptMap= new HashMap<>();
        for (Dept dept :deptList){
            allDeptMap.put(dept.getDid().toString(),dept.getDname());
        }
        map.put("allDepts",deptList) ;
        map.put("allLevels",levelList) ;
        map.put("allDeptMap",allDeptMap) ;
        map.put("allLevelMap",allLevelMap) ;
        return map;
    }
}
