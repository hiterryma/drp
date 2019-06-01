package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Action;

import java.sql.SQLException;
import java.util.Set;

public interface IActionDAO extends IBaseDAO<String, Action> {
    public Set<String> findAllByMember(Long did) throws SQLException;
}
