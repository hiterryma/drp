package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IWarehouseDAO;
import com.yootk.vo.Warehouse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class WarehouseDAOImpl extends AbstractDAO implements IWarehouseDAO {
    @Override
    public boolean doCreate(Warehouse warehouse) throws SQLException {
        String sql = "insert into warehouse (name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, warehouse.getName());
        super.pstmt.setLong(2, warehouse.getPid());
        super.pstmt.setLong(3, warehouse.getCid());
        super.pstmt.setLong(4, warehouse.getWiid());
        super.pstmt.setString(5, warehouse.getAddress());
        super.pstmt.setDouble(6, warehouse.getArea());
        super.pstmt.setInt(7, warehouse.getMaximum());
        super.pstmt.setInt(8, warehouse.getCurrnum());
        super.pstmt.setString(9, warehouse.getPhoto());
        super.pstmt.setString(10, warehouse.getNote());
        super.pstmt.setString(11, warehouse.getRecorder());
        super.pstmt.setString(12, warehouse.getAdmin());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Warehouse warehouse) throws SQLException {
        String sql = "update warehouse set name=?,pid=?,cid=?,wiid=?,address=?,area=?,maximum=?,photo=?,note=? where wid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, warehouse.getName());
        super.pstmt.setLong(2, warehouse.getPid());
        super.pstmt.setLong(3, warehouse.getCid());
        super.pstmt.setLong(4, warehouse.getWiid());
        super.pstmt.setString(5, warehouse.getAddress());
        super.pstmt.setDouble(6, warehouse.getArea());
        super.pstmt.setInt(7, warehouse.getMaximum());
        super.pstmt.setString(8, warehouse.getPhoto());
        super.pstmt.setString(9, warehouse.getNote());
        super.pstmt.setLong(10, warehouse.getWid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Warehouse findById(Long aLong) throws SQLException {
        String sql = "select wid,name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin from warehouse where wid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, aLong);
        return super.handleResultToVO(super.pstmt.executeQuery(), Warehouse.class);
    }

    @Override
    public List<Warehouse> findAll() throws SQLException {
        String sql = "select wid,name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin from warehouse";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Warehouse.class);
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "select wid,name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin from warehouse limit " + (currentPage - 1) * lineSize + " , " + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Warehouse.class);
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "select wid,name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin from warehouse where " + column + " like ? limit " + (currentPage - 1) * lineSize + " , " + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(), Warehouse.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
        return super.handleCount("warehouse");
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return super.handleCount("warehouse", column, keyWord);
    }

    @Override
    public boolean doEditAdmin(Long wid, String mid) throws SQLException {
        String sql = "update warehouse set admin=? where wid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, mid);
        super.pstmt.setLong(2, wid);
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public List<Warehouse> findAllByWiid(Long wiid) throws SQLException {
        String sql = "select wid,name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin from warehouse where wiid=?" ;
        super.pstmt =super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,wiid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Warehouse.class) ;
    }

    @Override
    public List<Warehouse> findAllByPCW(Long pid, Long cid, Long wiid) throws SQLException {
        String sql = "select wid,name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin from warehouse where pid=? and cid=? and wiid=?" ;
        super.pstmt =super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,pid);
        super.pstmt.setLong(2,cid);
        super.pstmt.setLong(3,wiid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Warehouse.class) ;
    }
}
