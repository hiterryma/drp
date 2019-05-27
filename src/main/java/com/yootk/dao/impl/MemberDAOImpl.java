package com.yootk.dao.impl;

import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.vo.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public Member findById(String s) throws SQLException {
        return null;
    }

    @Override
    public List<Member> findAll() throws SQLException {
        return null;
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
    public List<Member> findByIdAndPw(String mid) throws SQLException {
        List<Member> all = new ArrayList<>();
        String sql = "SELECT mid,password FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            Member vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setPassword(rs.getString(2));
            all.add(vo);
        }
        return all;
    }
}
