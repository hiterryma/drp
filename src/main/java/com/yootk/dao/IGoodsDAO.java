package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Goods;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IGoodsDAO extends IBaseDAO<Long, Goods> {
    /**
     * 根据已有的商品编号的信息查询出对应的所有商品数据
     * @param gids 要查询的商品的编号集合
     * @return 所有商品信息的列表操作
     * @throws SQLException JDBC
     */
    public List<Goods> findAllByGids(Set<Long> gids)throws SQLException;
}
