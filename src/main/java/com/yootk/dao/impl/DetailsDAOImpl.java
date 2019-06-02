package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IDetailsDAO;
import com.yootk.vo.Details;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Repository
public class DetailsDAOImpl extends AbstractDAO implements IDetailsDAO {
    @Override
    public boolean doCreateBatch(List<Details> allDetails) throws SQLException {
        String sql="insert into details(oid,gid,amount)values(?,?,?)";
        super.pstmt=super.conn.prepareStatement(sql);
        for(Details details:allDetails){
            super.pstmt.setLong(1,details.getOid());
            super.pstmt.setLong(2,details.getGid());
            super.pstmt.setInt(3,details.getAmount());
            super.pstmt.addBatch();
        }
        int result[]=super.pstmt.executeBatch();
        return super.isBatchSuccess(result);
    }

    @Override
    public Map<Long, Integer> findAllByOrders(Long oid) throws SQLException {
        Map<Long,Integer> map =  new HashMap<>() ;
        String sql = "SELECT gid,amount FROM details WHERE oid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,oid);
        ResultSet rs = super.pstmt.executeQuery() ;
        while (rs.next()) {
            map.put(rs.getLong(1),rs.getInt(2)) ;
        }
        return map;
    }

    @Override
    public boolean doCreate(Details details) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Details details) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Details findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Details> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Details> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Details> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
