package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IDistributionDetailsDAO;
import com.yootk.vo.DistributionDetails;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class DistributionDetailsDAOImpl extends AbstractDAO implements IDistributionDetailsDAO {
    @Override
    public boolean doCreate(DistributionDetails distributionDetails) throws SQLException {
        String sql = "insert into distribution_details (gid, name, price) values (?, ?, ?)";
//        System.out.println(distributionDetails);
        super.pstmt  = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, distributionDetails.getGid());
        super.pstmt.setString(2, distributionDetails.getName());
//        super.pstmt.setInt(3, distributionDetails.getNum());
        super.pstmt.setDouble(3, distributionDetails.getPrice());
//        super.pstmt.setInt(5, distributionDetails.getStatus());
//        super.pstmt.setLong(6, distributionDetails.getWid());
//        super.pstmt.setString(7, distributionDetails.getOutMid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(DistributionDetails distributionDetails) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public DistributionDetails findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<DistributionDetails> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<DistributionDetails> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<DistributionDetails> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
