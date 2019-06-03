package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IDistribution_memberDAO;
import com.yootk.dao.IDistribution_member_goodsDAO;
import com.yootk.vo.Distribution_member;
import com.yootk.vo.Distribution_member_goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class Distribution_memberDAOImpl extends AbstractDAO implements IDistribution_memberDAO {

    @Override
    public List<Distribution_member> findAllBysalemid(String salemid) throws SQLException {
        String sql = "SELECT dmid,cuid,salemid FROM distribution_member WHERE salemid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,salemid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Distribution_member.class) ;

    }

    @Override
    public List<Distribution_member> findAllByCuid(Long cuid) throws SQLException {
        String sql = "SELECT dmid,cuid,salemid FROM distribution_member WHERE cuid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,cuid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Distribution_member.class) ;

    }

    @Override
    public boolean doCreate(Distribution_member distribution_member) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Distribution_member distribution_member) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Distribution_member findById(Long dmid) throws SQLException {
        String sql = "SELECT dmid,cuid,salemid FROM distribution_member WHERE dmid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,dmid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,Distribution_member.class) ;
    }

    @Override
    public List<Distribution_member> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_member> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Distribution_member> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
