package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IGoodsDAO;
import com.yootk.dao.ISubtypeDAO;
import com.yootk.dao.IWitemDAO;
import com.yootk.service.back.IGoodsService;
import com.yootk.vo.Goods;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class GoodsServiceImpl extends AbstractService implements IGoodsService {

    @Autowired
    private IGoodsDAO goodsDAO;
    @Autowired
    private IWitemDAO witemDAO;
    @Autowired
    private ISubtypeDAO subtypeDAO;

    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("allWitems", witemDAO.findAll());
        return map;
    }

    @Override
    public boolean add(Goods goods) throws Exception {
        goods.setDelflag(0);
        goods.setLastin(new Date());
        goods.setStornum(0);
        return this.goodsDAO.doCreate(goods);
    }

    @Override
    public Map<String, Object> preEdit(Long gid) throws Exception {
        Goods goods = goodsDAO.findById(gid);
        Map<String, Object> map = new HashMap<>();
        map.put("goods", goodsDAO.findById(gid));
        map.put("allWitems", goods);
        map.put("allSubtypes", subtypeDAO.findAllByWitem(goods.getStid()));
        return map;
    }

    @Override
    public boolean edit(Goods goods) throws Exception {
        return false;
    }
}
