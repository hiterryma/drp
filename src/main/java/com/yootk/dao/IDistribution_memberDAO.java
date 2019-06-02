package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Distribution_member;

import java.sql.SQLException;
import java.util.List;

public interface IDistribution_memberDAO extends IBaseDAO<Long, Distribution_member> {
    public List<Distribution_member> findAllBysalemid(String salemid) throws SQLException ;
}
