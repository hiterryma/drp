package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ICsourceDAO;
import com.yootk.dao.ICustomerDAO;
import com.yootk.vo.Csource;
import com.yootk.vo.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class CustomerDAOImpl extends AbstractDAO implements ICustomerDAO {

    @Override
    public boolean doCreate(Customer customer) throws SQLException {
        String sql = "insert into customer (name, phone, pid, cid, address, indate, connum, ciid, csid, note, recorder, status, type, mid) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, customer.getName());
        super.pstmt.setString(2, customer.getPhone());
        super.pstmt.setLong(3, customer.getPid());
        super.pstmt.setLong(4, customer.getCid());
        super.pstmt.setString(5, customer.getAddress());
        super.pstmt.setTimestamp(6, new java.sql.Timestamp(customer.getIndate().getTime()));
        super.pstmt.setInt(7, customer.getConnum());
        super.pstmt.setLong(8, customer.getCiid());
        super.pstmt.setLong(9, customer.getCsid());
        super.pstmt.setString(10, customer.getNote());
        super.pstmt.setString(11, customer.getRecorder());
        super.pstmt.setInt(12, customer.getStatus());
        super.pstmt.setInt(13, customer.getType());
        super.pstmt.setString(14, customer.getMid());
        return super.pstmt.executeUpdate() > 0;
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
        String sql = "select cuid, name, phone, pid, cid, address, indate, connum, ciid, csid, note, recorder, status, type, mid from customer where status = 1 limit " + (currentPage - 1) * lineSize + " ," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Customer.class);
    }

    @Override
    public List<Customer> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "select cuid, name, phone, pid, cid, address, indate, connum, ciid, csid, note, recorder, status, type, mid from customer where status = 1 and " + column + " like ? limit " + (currentPage - 1) * lineSize + " ," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(), Customer.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
        String sql = "select count(*) from customer where status = 1";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        String sql = "select count(*) from customer where status = 0 and " + column + " like ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public List<Customer> findAllByStatus() throws SQLException {
        String sql = "select cuid, name, phone, pid, cid, address, indate, connum, ciid, csid, note, recorder, status, type, mid from customer where status = 0";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Customer.class);
    }

    @Override
    public Long getAllCountByStatus() throws SQLException {
        String sql = "select count(*) from customer where status = 0";
        super.pstmt = super.conn.prepareStatement(sql);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public Long getAllCountByStatus(String column, String keyword) throws SQLException {
        String sql = "select count(*) from customer where status = 0 and " + column + " like ?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyword + "%");
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()) {
            return rs.getLong(1);
        }
        return 0L;
    }

    @Override
    public List<Customer> findSplitByStatus(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "select cuid, name, phone, pid, cid, address, indate, connum, ciid, csid, note, recorder, status, type, mid from customer where status = 0 limit " + (currentPage - 1) * lineSize + " ," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(), Customer.class);
    }

    @Override
    public List<Customer> findSplitByStatus(Long currentPage, Integer lineSize, String column, String keyword) throws SQLException {
        String sql = "select cuid, name, phone, pid, cid, address, indate, connum, ciid, csid, note, recorder, status, type, mid from customer where status = 0 and " + column + " like ? limit " + (currentPage - 1) * lineSize + " ," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyword + "%");
        return super.handleResultToList(super.pstmt.executeQuery(), Customer.class);
    }
}
