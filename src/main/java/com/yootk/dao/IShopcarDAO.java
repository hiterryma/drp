package com.yootk.dao;


import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Shopcar;

import java.sql.SQLException;

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
}
