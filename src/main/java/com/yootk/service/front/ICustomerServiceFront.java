package com.yootk.service.front;

import com.yootk.vo.Customer;


public interface ICustomerServiceFront {

    /**
     * 查询用户的认证状态，0：表示未认证、1：表示认证成功、2：表示未认证失败
     * @param mid 查询的用户ID
     * @return
     * @throws Exception
     */
    public Integer getStatus(String mid) throws Exception;

    /**
     *  增加客户信息
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean add(Customer vo,String mid)throws Exception;
}
