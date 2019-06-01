package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ICityDAO;
import com.yootk.vo.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class CityDAOImpl extends AbstractDAO implements ICityDAO {
    @Override
    public boolean doCreate(City city) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(City city) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public City findById(Long aLong) throws SQLException {
        City city = null;
        String sql = "select cid,pid,title from city where cid = ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, aLong);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            city = new City();
            city.setCid(rs.getLong(1));
            city.setPid(rs.getLong(2));
            city.setTitle(rs.getString(3));
        }
        return city;
    }

    @Override
    public List<City> findAll() throws SQLException {
        String sql = "select cid, pid title from city";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), City.class);
    }

    @Override
    public List<City> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<City> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public List<City> findAllByProvince(Long pid) throws SQLException {
        String sql = "select cid, pid, title from city WHERE pid=? ";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,pid);
        return super.handleResultToList(super.pstmt.executeQuery(), City.class);
    }

}
