package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Dept;

import java.sql.SQLException;
import java.util.List;

public interface IDeptDAO extends IBaseDAO<Long, Dept> {

    @Override
    public boolean doEdit(Dept dept) throws SQLException;

    @Override
    List<Dept> findAll() throws SQLException;

    List<Dept> findAllMap() throws SQLException;
}
