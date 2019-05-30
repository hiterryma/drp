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
    public boolean add(Customer vo) throws Exception {
        return this.customerDAO.doCreate(vo);
    }
}
