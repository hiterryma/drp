package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Purchase;

import java.sql.SQLException;
import java.util.List;

public interface IPurchaseDAO extends IBaseDAO<Long, Purchase> {

    public List<Purchase> findAllById(String mid) throws SQLException;
}
