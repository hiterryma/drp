package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ICitemDAO;
import com.yootk.vo.Citem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class CitemDAOImpl extends AbstractDAO implements ICitemDAO {
    @Override
    public boolean doCreate(Citem citem) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Citem citem) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Citem findById(Long aLong) throws SQLException {
        String sql = "SELECT ciid,title FROM citem WHERE ciid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,aLong);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,Citem.class) ;
    }

    @Override
    public List<Citem> findAll() throws SQLException {
        String sql = "select ciid, title from citem";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Citem.class);
    }

    @Override
    public List<Citem> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Citem> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
