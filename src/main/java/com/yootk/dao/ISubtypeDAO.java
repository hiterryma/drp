package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Subtype;

import java.sql.SQLException;
import java.util.List;

public interface ISubtypeDAO extends IBaseDAO<Long, Subtype> {

    public List<Subtype> findAllByWitem(Long wiid) throws SQLException;

}
