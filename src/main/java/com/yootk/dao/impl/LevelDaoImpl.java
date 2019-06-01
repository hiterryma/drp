package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ILevelDAO;
import com.yootk.vo.Level;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class LevelDaoImpl extends AbstractDAO implements ILevelDAO {


    @Override
    public boolean doCreate(Level level) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Level level) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Level findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Level> findAll() throws SQLException {
        String sql = "select lid ,title from level " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Level.class);
    }

    @Override
    public List<Level> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Level> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
