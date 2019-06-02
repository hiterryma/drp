package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IAuditDAO;
import com.yootk.vo.Audit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class AuditDAOImpl extends AbstractDAO implements IAuditDAO {
    @Override
    public boolean doCreate(Audit audit) throws SQLException {
        String sql = "INSERT INTO audit (said,aud_member,aud_result,aud_date,aud_note) VALUES (?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,audit.getSaid());
        super.pstmt.setString(2,audit.getAud_member());
        super.pstmt.setInt(3,audit.getAud_result());
        super.pstmt.setDate(4,new java.sql.Date(audit.getAud_date().getTime()));
        super.pstmt.setString(5,audit.getAud_note());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Audit audit) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Audit findById(Long audid) throws SQLException {
        String sql = "SELECT audid,said,aud_member,aud_result,aud_date,aud_note FROM audit WHERE audid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,audid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,Audit.class) ;
    }

    @Override
    public List<Audit> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Audit> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Audit> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public List<Audit> findAllBySaid(Long said) throws SQLException {
        String sql = "SELECT audid,said,aud_member,aud_result,aud_date,aud_note FROM audit WHERE said=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,said);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Audit.class) ;
    }
}
