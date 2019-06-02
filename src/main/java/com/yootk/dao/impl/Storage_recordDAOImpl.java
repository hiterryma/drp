package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IStorage_recordDAO;
import com.yootk.vo.Storage_record;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class Storage_recordDAOImpl extends AbstractDAO implements IStorage_recordDAO {
    @Override
    public boolean doCreate(Storage_record storage_record) throws SQLException {
        String sql = "INSERT INTO storage_record (said,gid,name,num,price,weight,status,inmid) VALUES (?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,storage_record.getSaid()) ;
        super.pstmt.setLong(2,storage_record.getGid());
        super.pstmt.setString(3,storage_record.getName());
        super.pstmt.setInt(4,storage_record.getNum());
        super.pstmt.setDouble(5,storage_record.getPrice());
        super.pstmt.setDouble(6,storage_record.getWeight());
        super.pstmt.setInt(7,storage_record.getStatus());
        super.pstmt.setString(8,storage_record.getInmid());
        return super.pstmt.executeUpdate() > 0 ;

    }

    @Override
    public boolean doEdit(Storage_record storage_record) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Storage_record findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Storage_record> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Storage_record> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Storage_record> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
