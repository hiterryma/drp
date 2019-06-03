package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.ICustomerDAO;
import com.yootk.service.front.ICustomerServiceFront;
import com.yootk.vo.Customer;

@Service
public class CustomerServiceFrontImpl extends AbstractService implements ICustomerServiceFront {
    @Autowired
    private ICustomerDAO customerDAO;

    @Override
    public boolean add(Customer vo,String mid) throws Exception {
        if (this.customerDAO.findByMid(mid) == null) {   //等于 null 表示用户没有申请认证
            return this.customerDAO.doCreate(vo);
        }
        return false;
    }
}
