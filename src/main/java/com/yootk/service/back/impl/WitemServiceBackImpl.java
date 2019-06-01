package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IGoodsDAO;
import com.yootk.dao.ISubtypeDAO;
import com.yootk.dao.IWitemDAO;
import com.yootk.service.back.IWitemServiceBack;
import com.yootk.vo.Goods;
import com.yootk.vo.Subtype;
import com.yootk.vo.Witem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WitemServiceBackImpl extends AbstractService implements IWitemServiceBack {
    @Autowired
    private IWitemDAO witemDAO;
    @Autowired
    private ISubtypeDAO subtypeDAO;
    @Autowired
    private IGoodsDAO goodsDAO;

    @Override
    public Map<String ,Object> getAll() throws Exception {
        Map<String ,Object> map = new HashMap<>();
        map.put("allWitems",this.witemDAO.findAll());
        map.put("allSubtypes",this.subtypeDAO.findAll());
        map.put("allGoods",this.goodsDAO.findAll());
        return map;
    }
}
