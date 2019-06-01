package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IBaseDAO<Long, City> {
    public List<City> findAllByProvince(Long pid) throws SQLException;
}
