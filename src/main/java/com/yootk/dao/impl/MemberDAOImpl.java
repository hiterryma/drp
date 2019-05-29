package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.vo.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class MemberDAOImpl extends AbstractDAO implements IMemberDAO {
    @Override
    public boolean doCreate(Member member) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Member member) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<String> strings) throws SQLException {
        return false;
    }

    @Override
    public Member findById(String mid) throws SQLException {
        String sql = "select mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid from member where mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        return super.handleResultToVO(super.pstmt.executeQuery(), Member.class);
    }

    @Override
    public List<Member> findAll() throws SQLException {
        String sql = "select mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid from member ";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Member.class);
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Member> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount() throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public boolean doCreateByMember(Member vo) throws SQLException {
        String sql = "INSERT INTO member(mid,password) VALUES (?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getMid());
        super.pstmt.setString(2,vo.getPassword());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public Member findByIdAndpw(String id) throws SQLException {
        Member vo = null;
        String sql = "SELECT mid,name,password FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setName(rs.getString(2));
            vo.setPassword(rs.getString(3));
            return vo;
        }
        return null;
    }

    @Override
    public List<Member> findByDept(Long did) throws SQLException {
        String sql = "select mid,lid,did,name,sal,phone,password,photo,note,regdate,inmid,locked,type,email,cuid from member where did=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, did);
        return super.handleResultToList(super.pstmt.executeQuery(), Member.class);
    }
}
