package com.yootk.dao;


import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Shopcar;

import java.sql.SQLException;
import java.util.Map;

public interface IShopcarDAO extends IBaseDAO<Long, Shopcar> {
    /**
     * 根据用户的编号和商品的编号查询对应的购物车中的数据信息
     * @param mid 当前用户id
     * @param gid 购物车中商品信息
     * @return 如果有数量则返回其数量，如果没有则返回null
     * @throws SQLException 异常
     */
    public Integer findAmountByMemberAndGoods(String mid,Long gid)throws SQLException;

    /**
     * 根据用户的编号和商品的编号修改已有的数量信息
     * @param mid 当前用户id
     * @param gid 购物车中商品信息
     * @param amount 要修改的数量内容
     * @return 修改成功返回true，否则返回false
     * @throws SQLException JDBC
     */
    public boolean doEditAmountByMemberAndGoods(String mid,Long gid,Integer amount)throws SQLException;

    /**
     * 根据用户id查找出此用户的全部购物车的信息，为了方便页面的显示以及商品数据的查询，本次返回Map
     * Map中的key为商品id集合，Map中的value为商品的购物数量
     * @param mid 当前用户编号
     * @return 用户所购买的所有商品
     * @throws SQLException JDBC
     */
    public Map<Long,Integer> findAllByMember(String mid)throws SQLException;
}
