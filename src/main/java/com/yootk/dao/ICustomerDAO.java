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

    public boolean doEditForStatus(Integer status,String note,Long cuid) throws SQLException ;

    /**
     * 查询用户是否已经提交给客户认证申请
     * @param mid  需要查询的用户ID
     * @return
     * @throws SQLException
     */
    public Integer findByMid(String mid) throws SQLException;
}
