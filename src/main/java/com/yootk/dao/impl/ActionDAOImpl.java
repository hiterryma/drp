package com.yootk.dao.impl;


import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IActionDAO;
import com.yootk.vo.Action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ActionDAOImpl extends AbstractDAO implements IActionDAO {
    @Override
    public boolean doCreate(Action vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Action vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<String> strings) throws SQLException {
        return false;
    }

    @Override
    public Action findById(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Action> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Action> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Action> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount() throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Set<String> findAllByMember(Long did) throws SQLException {
        Set<String> actionSet = new HashSet<>();
        String sql ="SELECT actid FROM action WHERE rid IN ( SELECT rid FROM dept_role WHERE did=?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,did);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            actionSet.add(rs.getString(1));
        }
        return actionSet;
    }
}
