package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDAO extends IBaseDAO<Long, Customer> {

    public List<Customer> findAllByStatus() throws SQLException;

    public Long getAllCountByStatus() throws SQLException;

    public Long getAllCountByStatus(String column, String keyword) throws SQLException;

    public List<Customer> findSplitByStatus(Long currentPage, Integer lineSize) throws SQLException;
    public List<Customer> findSplitByStatus(Long currentPage, Integer lineSize, String column, String keyword) throws SQLException;

}
