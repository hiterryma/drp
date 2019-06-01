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
    public Double findPriceByGid(Long gid)throws SQLException;
    public Long getAllCountByStid(Long stid) throws SQLException;
    public Long getAllCountByStid(Long stid,String column, String keyWord) throws SQLException;
    /**
     * 根据商品的二级子分类
     * @param stid 二级子分类ID
     * @return 返回所有的二级子分类商品
     * @throws SQLException
     */
    public List<Goods> findByStid(Long stid,Long currentPage,Integer lineSize,String clonum,String keyword) throws SQLException;
    public List<Goods> findByStid(Long stid,Long currentPage,Integer lineSize) throws SQLException;


}
