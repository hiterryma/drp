package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ICritemDAO;
import com.yootk.vo.Critem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class CritemDAOImpl extends AbstractDAO implements ICritemDAO {
    @Override
    public boolean doCreate(Critem critem) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Critem critem) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Critem findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Critem> findAll() throws SQLException {
        String sql ="select criid,title from critem " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery();
        return super.handleResultToList(rs,Critem.class);
    }

    @Override
    public List<Critem> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Critem> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
