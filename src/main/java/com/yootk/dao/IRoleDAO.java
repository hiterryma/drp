package com.yootk.dao;


import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Role;

import java.sql.SQLException;
import java.util.Set;

public interface IRoleDAO extends IBaseDAO<String, Role> {
    public Set<String> findAllByMember(Long did) throws SQLException;
}
