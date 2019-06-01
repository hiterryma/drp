package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IBaseDAO<Long, City> {
    public List<City> findAllByProvince(Long pid) throws SQLException;
    /**
     * 根据省份编号创建相应的城市数据信息
     * @param pid 省份编号
     * @return 对应的所有城市内容
     * @throws SQLException 异常
     */
}
