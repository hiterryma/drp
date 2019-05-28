package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Storage_apply;

import java.sql.SQLException;

public interface IStorage_applyDAO extends IBaseDAO<Long, Storage_apply> {

    Long findLastId() throws SQLException;
}
