package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Submitdate;

import java.sql.SQLException;

public interface ISubmitdateDAO extends IBaseDAO<Long, Submitdate> {
    /**
     * 根据清单id查询请提交日期数据
     * @param said
     * @return
     * @throws SQLException
     */
    public Submitdate findBySaid(Long said) throws SQLException ;
}
