package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Distribution_member;

import java.sql.SQLException;
import java.util.List;

public interface IDistribution_memberDAO extends IBaseDAO<Long, Distribution_member> {
    public List<Distribution_member> findAllBysalemid(String salemid) throws SQLException ;

    /**
     * 根据客户id查询出该客户的所有出库意向
     * @param cuid
     * @return
     * @throws SQLException
     */
    public List<Distribution_member> findAllByCuid(Long cuid) throws SQLException ;
}
