package com.yootk.service.back.impl;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IGoodsDAO;
import com.yootk.service.back.IGoodsServiceBack;
import com.yootk.vo.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceBackImpl extends AbstractService implements IGoodsServiceBack {
    @Autowired
    private IGoodsDAO goodsDAO;
    @Override
    public List<Goods> getByStid(Long stid) throws Exception {
        List<Goods> all = this.goodsDAO.findByStid(stid);
        return all;
    }

    @Override
    public Goods get(Long gid) throws Exception {

        return this.goodsDAO.findById(gid) ;
    }

}
