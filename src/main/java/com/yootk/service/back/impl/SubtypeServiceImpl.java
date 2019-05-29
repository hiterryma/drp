package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.ISubtypeDAO;
import com.yootk.service.back.ISubtypeService;
import com.yootk.vo.Subtype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SubtypeServiceImpl extends AbstractService implements ISubtypeService {

    @Autowired
    private ISubtypeDAO subtypeDAO;

    @Override
    public List<Subtype> findAllByWitem(Long wiid) throws Exception {
       return this.subtypeDAO.findAllByWitem(wiid);
    }
}
