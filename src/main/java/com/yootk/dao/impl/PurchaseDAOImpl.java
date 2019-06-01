package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IPurchaseDAO;
import com.yootk.vo.Purchase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class PurchaseDAOImpl extends AbstractDAO implements IPurchaseDAO {
    @Override
    public boolean doCreate(Purchase purchase) throws SQLException {
        String sql = "INSERT INTO purchase (title,mid,name,phone,address,note,subdate,state,cid,pid ) VALUES (?,?,?,?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,purchase.getTitle());
        super.pstmt.setString(2,purchase.getMid());
        super.pstmt.setString(3,purchase.getName());
        super.pstmt.setString(4,purchase.getPhone());
        super.pstmt.setString(5,purchase.getAddress());
        super.pstmt.setString(6,purchase.getNote());
        super.pstmt.setDate(7,new java.sql.Date(purchase.getSubdate().getTime()));
        super.pstmt.setInt(8,purchase.getState());
        super.pstmt.setInt(9,purchase.getCid());
        super.pstmt.setInt(10,purchase.getPid());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEdit(Purchase purchase) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Purchase findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Purchase> findAll() throws SQLException {
        List<Purchase> all = new ArrayList<>();
        String sql = "SELECT title,note,subdate,state FROM purchase";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            Purchase vo = new Purchase();
            vo.setTitle(rs.getString(1));
            vo.setNote(rs.getString(2));
            vo.setSubdate(rs.getDate(3));
            vo.setState(rs.getInt(4));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Purchase> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Purchase> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
