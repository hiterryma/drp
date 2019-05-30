package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ICustomerDAO;
import com.yootk.vo.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class CustomerDAOImpl extends AbstractDAO implements ICustomerDAO {

    @Override
    public boolean doCreate(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer(name,phone,pid,cid,address,indate,connum,ciid,csid,note,recorder,status,type,mid) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,customer.getName());
        super.pstmt.setString(2,customer.getPhone());
        super.pstmt.setLong(3,customer.getPid());
        super.pstmt.setLong(4,customer.getCid());
        super.pstmt.setString(5,customer.getAddress());
        super.pstmt.setDate(6,new java.sql.Date(customer.getIndate().getTime()));
        super.pstmt.setInt(7,customer.getConnum());
        super.pstmt.setLong(8,customer.getCiid());
        super.pstmt.setLong(9,customer.getCsid());
        super.pstmt.setString(10,customer.getNote());
        super.pstmt.setString(11,customer.getRecorder());
        super.pstmt.setInt(12,customer.getStatus());
        super.pstmt.setInt(13,customer.getType());
        super.pstmt.setString(14,customer.getMid());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEdit(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Customer findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
