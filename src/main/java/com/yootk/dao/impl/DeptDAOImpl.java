package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IDeptDAO;
import com.yootk.vo.Dept;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class DeptDAOImpl extends AbstractDAO implements IDeptDAO {

    @Override
    public boolean doCreate(Dept dept) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Dept dept) throws SQLException {
        String sql = "update dept set dname=? where did=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,dept.getDname());
        super.pstmt.setLong(2,dept.getDid());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Dept findById(Long aLong) throws SQLException {
        String sql = "select did,dname,mid from dept where did =?";
        super.pstmt = super.conn.prepareStatement(sql );
        super.pstmt.setLong(1,aLong);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,Dept.class);
    }

    @Override
    public List<Dept> findAll() throws SQLException {
        String sql = "select did,dname,mid from dept";
        super.pstmt = super.conn.prepareStatement(sql );
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Dept.class);
    }

    @Override
    public List<Dept> findSplit(Long currentPage, Integer lineSize) throws SQLException {

        String sql = "select did,dname,mid from dept  LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql );
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Dept.class);
    }

    @Override
    public List<Dept> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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

}
