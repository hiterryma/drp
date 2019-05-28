package com.yootk.dao.impl;

import com.sun.org.apache.xml.internal.security.Init;
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
    public Long findDidByDeptAndMember(String mid) throws SQLException {
        String sql = "SELECT did FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public boolean doEditPasswordByMember(String newpassword,String mid) throws SQLException {
        String sql = "UPDATE member SET password=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,newpassword);
        super.pstmt.setString(2,mid);
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEditDatumByMember(Member vo) throws SQLException {
        String sql = "UPDATE member SET name=?,phone=?,email=? WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,vo.getName());
        super.pstmt.setString(2,vo.getPhone());
        super.pstmt.setString(3,vo.getEmail());
        super.pstmt.setString(4,vo.getMid());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public Member findDatumByMember(String mid) throws SQLException {
        Member vo = null;
        String sql = "SELECT name,phone,email FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            vo = new Member();
            vo.setName(rs.getString(1));
            vo.setPhone(rs.getString(2));
            vo.setEmail(rs.getString(3));
        }
        return vo;
    }

    @Override
    public String findMemberById(String mid) throws SQLException {
        String sql = "SELECT mid FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

    @Override
    public Integer findTypeByMember(String mid) throws SQLException {
        String sql = "SELECT type FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean doCreateByMember(Member vo) throws SQLException {
        String sql = "INSERT INTO member(mid,name,password) VALUES (?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, vo.getMid());
        super.pstmt.setString(2, vo.getName());
        super.pstmt.setString(3, vo.getPassword());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public Member findByIdAndpw(String id) throws SQLException {
        Member vo = null;
        String sql = "SELECT mid,name,password FROM member WHERE mid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, id);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()) {
            vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setName(rs.getString(2));
            vo.setPassword(rs.getString(3));
            return vo;
        }
        return null;
    }
}
