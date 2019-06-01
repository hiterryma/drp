package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IStorage_applyDAO;
import com.yootk.vo.City;
import com.yootk.vo.Storage_apply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class Stroage_applyDAOImpl extends AbstractDAO implements IStorage_applyDAO {
    @Override
    public boolean doCreate(Storage_apply storage_apply) throws SQLException {

        String sql = "INSERT INTO storage_apply (title,pid,cid,wiid,wid,note,status,appmid) VALUES (?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,storage_apply.getTitle());
        super.pstmt.setLong(2,storage_apply.getPid());
        super.pstmt.setLong(3,storage_apply.getCid());
        super.pstmt.setLong(4,storage_apply.getWiid());
        super.pstmt.setLong(5,storage_apply.getWid());
        super.pstmt.setString(6,storage_apply.getNote());
        super.pstmt.setInt(7,storage_apply.getStatus());
        super.pstmt.setString(8,storage_apply.getAppmid());

        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Storage_apply storage_apply) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> saids) throws SQLException {
        //调用父类AbstractDAO中的方法实现批量删除
        return handleRemove("storage_apply","said",saids) ;
    }

    @Override
    public Storage_apply findById(Long aLong) throws SQLException {
        Storage_apply storage_apply = null;
        String sql = "select mid from storage_apply where wid = ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, aLong);
        ResultSet rs = super.pstmt.executeQuery();
        if (rs.next()){
            storage_apply = new Storage_apply();
            storage_apply.setMid(rs.getString(1));
        }
        return storage_apply;
    }

    @Override
    public List<Storage_apply> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Storage_apply> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null ;
    }

    @Override
    public List<Storage_apply> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public Long findLastId() throws SQLException {
        return super.getLastId() ;
    }
}
