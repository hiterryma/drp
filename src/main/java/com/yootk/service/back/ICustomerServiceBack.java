package com.yootk.service.back;

import com.yootk.vo.Customer;
import com.yootk.vo.CustomerRecord;

import java.util.Map;

public interface ICustomerServiceBack {

    public Map<String, Object> preAdd() throws Exception;

    public boolean add(Customer customer) throws Exception;

    public boolean edit(Customer customer) throws Exception ;

    public Map<String,Object> preAddCustomerRecord() throws Exception ;
    /**
     * 针对认证状态添加更新操作
     * @param status
     * @return
     * @throws Exception
     */
    public boolean editForStatus(Integer status,String note,Long cuid) throws Exception ;

    public boolean addForCustomerRecord(CustomerRecord customerRecord) throws Exception;

    public Map<String,Object> listForCustomerRecord(Long currentPage, Integer lineSize, String column, String keyword) throws Exception;

    public Map<String, Object> listByStatus(Long currentPage, Integer lineSize, String column, String keyword) throws Exception;

    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception;

}
