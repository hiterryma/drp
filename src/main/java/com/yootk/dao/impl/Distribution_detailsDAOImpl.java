package com.yootk.dao.impl;

import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IDistribution_detailsDAO;
import com.yootk.vo.Distribution_details;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class Distribution_detailsDAOImpl extends AbstractDAO implements IDistribution_detailsDAO {
    @Override
    public boolean doCreate(Distribution_details distribution_details) throws SQLException {
        String sql = "INSERT INTO distribution_details (gid,name,num,price,status,wid,outmid) VALUES (?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,distribution_details.getGid());
        super.pstmt.setString(2,distribution_details.getName());
        super.pstmt.setInt(3,distribution_details.getNum());
        super.pstmt.setDouble(4,distribution_details.getPrice());
        super.pstmt.setInt(5,distribution_details.getStatus());
        super.pstmt.setLong(6,distribution_details.getWid());
        super.pstmt.setString(7,distribution_details.getOutmid());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Distribution_details distribution_details) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Distribution_details findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_details> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_details> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_details> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
