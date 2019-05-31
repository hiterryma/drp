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
    public List<Goods> getByStid(Long stid) throws Exception;

    /**
     * 根据商品id查询出指定的商品信息
     * @param gid
     * @return
     * @throws Exception
     */
    public Goods get(Long gid) throws Exception ;
}
