package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Warehouse;

import java.sql.SQLException;
import java.util.List;

public interface IWarehouseDAO extends IBaseDAO<Long, Warehouse> {
    public List<Warehouse> findAllByWiid(Long wiid) throws SQLException ;
    public List<Warehouse> findAllByPCW(Long pid, Long cid, Long wiid) throws SQLException ;
}
