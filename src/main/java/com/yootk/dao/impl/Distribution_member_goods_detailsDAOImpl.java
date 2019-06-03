package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IDistribution_member_goods_detailsDAO;
import com.yootk.vo.Distribution_member_goods_details;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class Distribution_member_goods_detailsDAOImpl extends AbstractDAO implements IDistribution_member_goods_detailsDAO {
    @Override
    public boolean doCreate(Distribution_member_goods_details distribution_member_goods_details) throws SQLException {
        String sql = "INSERT INTO distribution_member_goods_details (dmgid,gnum) VALUES (?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,distribution_member_goods_details.getDmgid());
        super.pstmt.setInt(2,distribution_member_goods_details.getGnum());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Distribution_member_goods_details distribution_member_goods_details) throws SQLException {
        String sql = "UPDATE distribution_member_goods_details SET dmgid=?,gnum=? WHERE dmgdid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,distribution_member_goods_details.getDmgid());
        super.pstmt.setInt(2,distribution_member_goods_details.getGnum());
        super.pstmt.setLong(3,distribution_member_goods_details.getDmgdid());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Distribution_member_goods_details findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_member_goods_details> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_member_goods_details> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_member_goods_details> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
