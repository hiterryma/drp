package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IStorage_apply_detailsDAO;
import com.yootk.vo.Storage_apply_details;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class Storage_apply_detailsDAOImpl extends AbstractDAO implements IStorage_apply_detailsDAO {


    @Override
    public boolean doCreate(Storage_apply_details storage_apply_details) throws SQLException {
        String sql = "INSERT INTO storage_apply_details (said,gid,name,num,price,weight) VALUES (?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,storage_apply_details.getSaid());
        super.pstmt.setLong(2,storage_apply_details.getGid());
        super.pstmt.setString(3,storage_apply_details.getName());
        super.pstmt.setInt(4,storage_apply_details.getNum());
        super.pstmt.setDouble(5,storage_apply_details.getPrice());
        super.pstmt.setDouble(6,storage_apply_details.getWeight());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Storage_apply_details storage_apply_details) throws SQLException {
        String sql = "UPDATE storage_apply_details SET said=?,gid=?,name=?,num=?,price=?,weight=? WHERE sadid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,storage_apply_details.getSaid());
        super.pstmt.setLong(2,storage_apply_details.getGid());
        super.pstmt.setString(3,storage_apply_details.getName());
        super.pstmt.setInt(4,storage_apply_details.getNum());
        super.pstmt.setDouble(5,storage_apply_details.getPrice());
        super.pstmt.setDouble(6,storage_apply_details.getWeight());
        super.pstmt.setLong(7,storage_apply_details.getSadid());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Storage_apply_details findById(Long sadid) throws SQLException {
        String sql = "SELECT sadid,said,gid,name,num,price,weight FROM storage_apply_details WHERE sadid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,sadid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,Storage_apply_details.class) ;
    }

    @Override
    public List<Storage_apply_details> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Storage_apply_details> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Storage_apply_details> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public List<Storage_apply_details> findAllBySaid(Long said) throws SQLException {
        String sql = "SELECT sadid,said,gid,name,num,price,weight FROM storage_apply_details WHERE said=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,said);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Storage_apply_details.class) ;
    }
}
