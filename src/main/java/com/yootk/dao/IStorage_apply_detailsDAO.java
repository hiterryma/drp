package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Storage_apply_details;

import java.sql.SQLException;
import java.util.List;

public interface IStorage_apply_detailsDAO extends IBaseDAO<Long, Storage_apply_details> {
    /**
     * 申请单详情是没有业务层的，而是在申请单的业务层中，但创建申请单时顺便创建申请单详情
     * @param allStorage_apply_details
     * @return
     * @throws SQLException
     */
    public boolean doCreateBatch(List<Storage_apply_details> allStorage_apply_details) throws SQLException;
}
