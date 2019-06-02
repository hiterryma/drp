package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Audit;

import java.sql.SQLException;
import java.util.List;

public interface IAuditDAO extends IBaseDAO<Long, Audit> {
    //根据清单编号查询出它以前所有的审核信息
    public List<Audit> findAllBySaid(Long said) throws SQLException ;
}
