package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Details;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IDetailsDAO extends IBaseDAO<Long, Details> {
    public boolean doCreateBatch(List<Details> allDetails)throws SQLException;
    /**
     * 根据订单的编号查询出此订单之中所对应的全部商品信息
     * @param oid 订单编号
     * @return 返回包含有商品编号和数量的Map集合
     * @throws SQLException JDBC异常
     */
    public Map<Long,Integer> findAllByOrders(Long oid) throws SQLException ;
}
