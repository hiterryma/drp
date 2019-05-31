package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Storage_apply_details;

import java.sql.SQLException;
import java.util.List;

public interface IStorage_apply_detailsDAO extends IBaseDAO<Long, Storage_apply_details> {

    /**
     * 根据申请单编号查询出所有的详情信息
     * @param said
     * @return
     * @throws SQLException
     */
    public List<Storage_apply_details> findAllBySaid(Long said) throws SQLException ;
}
