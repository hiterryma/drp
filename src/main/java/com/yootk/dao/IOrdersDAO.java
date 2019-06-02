package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Orders;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface IOrdersDAO extends IBaseDAO<Long, Orders> {
    public Long findLastId()throws SQLException;
    public List<Orders> findSplitByMember(String mid, Long currentPage, Integer lineSize) throws SQLException ;
    public Long getAllCountByMember(String mid) throws SQLException ;
    public boolean doCreate(String aid, Set<Long> gids ,String note)throws SQLException;
}
