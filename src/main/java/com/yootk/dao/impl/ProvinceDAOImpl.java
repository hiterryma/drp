package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IProvinceDAO;
import com.yootk.vo.Province;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class ProvinceDAOImpl extends AbstractDAO implements IProvinceDAO {
    @Override
    public boolean doCreate(Province province) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Province province) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Province findById(Long aLong) throws SQLException {
        Province vo = null;
        String sql = "SELECT pid,title FROM province WHERE pid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,aLong);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            vo = new Province();
            vo.setPid(rs.getLong(1));
            vo.setTitle(rs.getString(2));
        }
        return vo;
    }

    @Override
    public List<Province> findAll() throws SQLException {
        String sql = "select pid, title from province";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Province.class);
    }

    @Override
    public List<Province> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Province> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
