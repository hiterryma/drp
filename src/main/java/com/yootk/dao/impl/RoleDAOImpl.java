package com.yootk.dao.impl;


import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IRoleDAO;
import com.yootk.vo.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAOImpl extends AbstractDAO implements IRoleDAO {
    @Override
    public Set<String> findAllByMember(Long did) throws SQLException {
        Set<String> roleSet = new HashSet<>();
        String sql ="SELECT rid FROM role WHERE rid IN ( SELECT rid FROM dept_role WHERE did=? )";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,did);
        ResultSet rs = super.pstmt.executeQuery();
        while (rs.next()){
            roleSet.add(rs.getString(1));
        }
        return roleSet;
    }

    @Override
    public boolean doCreate(Role vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Role vo) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<String> strings) throws SQLException {
        return false;
    }


    @Override
    public Role findById(String id) throws SQLException {
        String sql = "SELECT rid";
        super.pstmt = super.conn.prepareStatement(sql);
        return null;
    }

    @Override
    public List<Role> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Role> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Role> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
}
