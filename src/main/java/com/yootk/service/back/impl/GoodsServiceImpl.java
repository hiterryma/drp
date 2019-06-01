package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IGoodsDAO;
import com.yootk.dao.IMemberDAO;
import com.yootk.dao.ISubtypeDAO;
import com.yootk.dao.IWitemDAO;
import com.yootk.service.back.IGoodsService;
import com.yootk.vo.Goods;
import com.yootk.vo.Member;

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
    @Autowired
    private IMemberDAO memberDAO;

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
        map.put("allWitems", this.witemDAO.findAll());
        map.put("allSubtypes", subtypeDAO.findAllByWitem(goods.getWiid()));
        return map;
    }

    @Override
    public boolean edit(Goods goods) throws Exception {
        return this.goodsDAO.doEdit(goods);
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<>();

        Map<String, String> allMemberMap = new HashMap<>();
        for (Member member:this.memberDAO.findAll()) {
            allMemberMap.put(member.getMid(), member.getName());
        }
        map.put("allMemberMap", allMemberMap);
        if (column == null || "".equals(column) || keyword == null || "".equals(keyword)) {
            map.put("allRecorders", this.goodsDAO.getAllCount());
            map.put("allGoods", this.goodsDAO.findSplit(currentPage, lineSize));
        }else {
            map.put("allRecorders", this.goodsDAO.getAllCount(column, keyword));
            map.put("allGoods", this.goodsDAO.findSplit(currentPage, lineSize, column, keyword));
        }
        return map;
    }


}
