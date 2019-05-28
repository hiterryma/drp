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
        String sql = "INSERT INTO warehouse (name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin) VALUES (?,?,,?,?,?,?,?,?,?,?,?,?)";
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
        String sql = "UPDATE warehouse SET name=?,pid=?,cid=?,wiid=?,address=?,area=?,maximum=?,currnum=?,photo=?,note=?,recorder=?,admin=? WHERE wid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,warehouse.getName());
        super.pstmt.setLong(2,warehouse.getPid());
        super.pstmt.setLong(3,warehouse.getCid());
        super.pstmt.setLong(4,warehouse.getWiid());
        super.pstmt.setString(5,warehouse.getAddress());
        super.pstmt.setDouble(6,warehouse.getArea());
        super.pstmt.setInt(7,warehouse.getMaximum());
        super.pstmt.setInt(8,warehouse.getCurrnum());
        super.pstmt.setString(9,warehouse.getPhoto());
        super.pstmt.setString(10,warehouse.getNote());
        super.pstmt.setString(11,warehouse.getRecorder());
        super.pstmt.setString(12,warehouse.getAdmin());
        super.pstmt.setLong(13,warehouse.getWid());
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Warehouse findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Warehouse> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        /**
         * 只能查询出仓库的类型编号和管理员编号，不能查出仓库类型名称和管理员名称
         */

        String sql = "SELECT wid,name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin FROM warehouse LIMIT " + (currentPage - 1)*lineSize + "," + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs ,Warehouse.class) ;
    }

    @Override
    public List<Warehouse> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {

        String sql = "SELECT wid,name,pid,cid,wiid,address,area,maximum,currnum,photo,note,recorder,admin FROM warehouse WHERE "+ column +"LIKE ? LIMIT " + (currentPage - 1)*lineSize + "," + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs ,Warehouse.class) ;
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
