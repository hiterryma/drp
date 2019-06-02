package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IDistribution_member_goodsDAO;
import com.yootk.vo.Distribution_member_goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class Distribution_member_goodsDAOImpl extends AbstractDAO implements IDistribution_member_goodsDAO {
    @Override
    public boolean doCreate(Distribution_member_goods distribution_member_goods) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Distribution_member_goods distribution_member_goods) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Distribution_member_goods findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_member_goods> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_member_goods> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_member_goods> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public List<Distribution_member_goods> findAllByDmid(Long dmid) throws SQLException {
        String sql = "SELECT dmgid,dmid,gid FROM distribution_member_goods WHERE dmid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,dmid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Distribution_member_goods.class) ;
    }
}
