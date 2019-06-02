package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ISubmitdateDAO;
import com.yootk.vo.Submitdate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class SubmitdateDAOImpl extends AbstractDAO implements ISubmitdateDAO {
    @Override
    public boolean doCreate(Submitdate submitdate) throws SQLException {
        String sql = "INSERT INTO submitdate (said,submit_date) VALUES (?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,submitdate.getSaid());
        super.pstmt.setDate(2,new java.sql.Date(submitdate.getSubmit_date().getTime()));
        return super.pstmt.executeUpdate() >0 ;
    }

    @Override
    public boolean doEdit(Submitdate submitdate) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Submitdate findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Submitdate> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Submitdate> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Submitdate> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public Submitdate findBySaid(Long said) throws SQLException {
        String sql = "SELECT sdateid,said,submit_date FROM submitdate WHERE said=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,said);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,Submitdate.class) ;
    }
}
