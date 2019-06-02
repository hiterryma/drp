package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Distribution_member_goods;

import java.sql.SQLException;
import java.util.List;

public interface IDistribution_member_goodsDAO extends IBaseDAO<Long, Distribution_member_goods> {
    public List<Distribution_member_goods> findAllByDmid(Long dmid) throws SQLException ;
}
