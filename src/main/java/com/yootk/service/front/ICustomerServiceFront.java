package com.yootk.service.front;

import com.yootk.vo.Customer;


public interface ICustomerServiceFront {

    /**
     *  增加客户信息
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean add(Customer vo,String mid)throws Exception;
}
