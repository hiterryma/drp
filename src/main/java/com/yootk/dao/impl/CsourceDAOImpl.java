package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ICsourceDAO;
import com.yootk.vo.Csource;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class CsourceDAOImpl extends AbstractDAO implements ICsourceDAO {
    @Override
    public boolean doCreate(Csource csource) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Csource csource) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Csource findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Csource> findAll() throws SQLException {
        String sql = "select csid, title from csource";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Csource.class);
    }

    @Override
    public List<Csource> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Csource> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
