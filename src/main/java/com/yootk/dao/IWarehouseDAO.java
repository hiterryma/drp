package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Warehouse;

import java.sql.SQLException;

public interface IWarehouseDAO extends IBaseDAO<Long, Warehouse> {

    public boolean doEditAdmin(Long wid, String mid)throws SQLException;

}
