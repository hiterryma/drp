package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Customer;

import java.sql.SQLException;

public interface ICustomerDAO extends IBaseDAO<Long, Customer> {
    /**
     * 查询用户是否已经提交给客户认证申请
     * @param mid  需要查询的用户ID
     * @return
     * @throws SQLException
     */
    public Integer findByMid(String mid) throws SQLException;
}
