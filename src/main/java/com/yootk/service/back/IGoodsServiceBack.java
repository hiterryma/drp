package com.yootk.service.back;

import com.yootk.vo.Goods;

import java.util.List;
import java.util.Map;

public interface IGoodsServiceBack {
    /**
     * 查询所有的二级子分类商品
     * @param stid
     * @return
     * @throws Exception
     */
    public Map<String, Object> getByStid(Long stid,Long currentPage,Integer lineSize,String clonum,String keyword) throws Exception;
}
