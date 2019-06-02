package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IDetailsDAO;
import com.yootk.service.front.IDetailsService;
import com.yootk.vo.Details;

import java.util.List;
@Service
public class DetailsServiceImpl extends AbstractService implements IDetailsService {
    @Autowired
    private IDetailsDAO detailsDAO;
    /*@Override
    public boolean add(List<Details> allDetails) throws Exception {
        return this.detailsDAO.doCreateBatch(allDetails);
    }*/
}
