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
    public Map<String, Object> getByStid(Long stid,Long currentPage,Integer lineSize,String clonum,String keyword) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        if (super.isEmpty(clonum, keyword)) { // 不需要进行模糊查询
            map.put("allGoods", this.goodsDAO.findByStid(stid,currentPage, lineSize));
            map.put("allRecorders", this.goodsDAO.getAllCount());
        } else {
            map.put("allGoods", this.goodsDAO.findByStid(stid,currentPage, lineSize, clonum, keyword));
            map.put("allRecorders", this.goodsDAO.getAllCount(clonum, keyword));
        }
        System.out.println(map.get("allGoods"));
        return map;
    }
}
