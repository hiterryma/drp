package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IWitemDAO;
import com.yootk.vo.Subtype;
import com.yootk.vo.Witem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class WitemDAOImpl extends AbstractDAO implements IWitemDAO {
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
        List<Witem> all = new ArrayList<>();
        String sql = "SELECT wiid,title FROM witem";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Witem vo = new Witem();
            vo.setWiid(rs.getLong(1));
            vo.setTitle(rs.getString(2));
            all.add(vo);
        }
        return all;
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
