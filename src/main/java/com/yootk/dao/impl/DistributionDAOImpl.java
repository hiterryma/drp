package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IDistributionDAO;
import com.yootk.vo.Distribution;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class DistributionDAOImpl extends AbstractDAO implements IDistributionDAO {
    @Override
    public boolean doCreate(Distribution distribution) throws SQLException {
        String sql = "INSERT INTO distribution (title,pid,cid,gnum,price,status,note) VALUES (?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,distribution.getTitle());
        super.pstmt.setLong(2,distribution.getPid());
        super.pstmt.setLong(3,distribution.getCid());
        super.pstmt.setInt(4,distribution.getGnum());
        super.pstmt.setDouble(5,distribution.getPrice());
        super.pstmt.setInt(6,distribution.getStatus());
        super.pstmt.setString(7,distribution.getNote());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Distribution distribution) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Distribution findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Distribution> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
