package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Goods;

import java.sql.SQLException;
import java.util.List;

public interface IGoodsDAO extends IBaseDAO<Long, Goods> {
    /**
     * 根据商品的二级子分类
     * @param stid 二级子分类ID
     * @return 返回所有的二级子分类商品
     * @throws SQLException
     */
    public List<Goods> findByStid(Long stid) throws SQLException;
}
