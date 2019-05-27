package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IWitemDAO;
import com.yootk.vo.Witem;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class ItemDAOImpl extends AbstractDAO implements IWitemDAO {
    @Override
    public boolean doCreate(Witem witem) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Witem witem) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Witem findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Witem> findAll() throws SQLException {
        String sql = "select wiid title from witem";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Witem.class);
    }

    @Override
    public List<Witem> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Witem> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
