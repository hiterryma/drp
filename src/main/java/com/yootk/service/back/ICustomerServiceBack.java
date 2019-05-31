package com.yootk.service.back;

import com.yootk.vo.Customer;

import java.util.Map;

public interface ICustomerServiceBack {

    public Map<String, Object> preAdd() throws Exception;

    public boolean add(Customer customer) throws Exception;

    public Map<String, Object> listByStatus(Long currentPage, Integer lineSize, String column, String keyword) throws Exception;

    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception;

}
