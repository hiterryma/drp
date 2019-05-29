package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ISubtypeDAO;
import com.yootk.vo.Subtype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Repository
public class SubtypeDAOImpl extends AbstractDAO implements ISubtypeDAO {
    @Override
    public boolean doCreate(Subtype subtype) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Subtype subtype) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Subtype findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Subtype> findAll() throws SQLException {
        List<Subtype> all = new ArrayList<>();
        String sql = "SELECT stid,title,wiid FROM subtype";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Subtype vo = new Subtype();
            vo.setStid(rs.getLong(1));
            vo.setTitle(rs.getString(2));
            vo.setWiid(rs.getLong(3));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Subtype> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Subtype> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public List<Subtype> findAllByWitem(Long wiid) throws SQLException {
        String sql = "select stid, title, wiid from subtype where wiid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, wiid);
        return super.handleResultToList(super.pstmt.executeQuery(), Subtype.class);
    }
}
