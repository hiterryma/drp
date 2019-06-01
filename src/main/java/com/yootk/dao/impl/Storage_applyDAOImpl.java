package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IStorage_applyDAO;
import com.yootk.vo.Storage_apply;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class Storage_applyDAOImpl extends AbstractDAO implements IStorage_applyDAO {
    @Override
    public boolean doCreate(Storage_apply storage_apply) throws SQLException {

        String sql = "INSERT INTO storage_apply (mid,title,pid,cid,wiid,wid,note,outorin,submit_status,audit_status,appmid) VALUES (?,?,?,?,?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,storage_apply.getMid());
        super.pstmt.setString(2,storage_apply.getTitle());
        super.pstmt.setLong(3,storage_apply.getPid());
        super.pstmt.setLong(4,storage_apply.getCid());
        super.pstmt.setLong(5,storage_apply.getWiid());
        super.pstmt.setLong(6,storage_apply.getWid());
        super.pstmt.setString(7,storage_apply.getNote());
        super.pstmt.setInt(8,storage_apply.getOutorin());

        super.pstmt.setInt(9,storage_apply.getSubmit_status());
        super.pstmt.setInt(10,storage_apply.getAudit_status());
        super.pstmt.setString(11,storage_apply.getAppmid());

        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Storage_apply storage_apply) throws SQLException {
        String sql = "UPDATE storage_apply SET mid=?,title=?,pid=?,cid=?,wiid=?,wid=?,note=?,outorin=?,submit_status=?,audit_status=?,appmid=? WHERE said=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,storage_apply.getMid());
        super.pstmt.setString(2,storage_apply.getTitle());
        super.pstmt.setLong(3,storage_apply.getPid());
        super.pstmt.setLong(4,storage_apply.getCid());
        super.pstmt.setLong(5,storage_apply.getWiid());
        super.pstmt.setLong(6,storage_apply.getWid());
        super.pstmt.setString(7,storage_apply.getNote());
        super.pstmt.setInt(8,storage_apply.getOutorin());

        super.pstmt.setInt(9,storage_apply.getSubmit_status());
        super.pstmt.setInt(10,storage_apply.getAudit_status());
        super.pstmt.setString(11,storage_apply.getAppmid());
        super.pstmt.setLong(12,storage_apply.getSaid());

        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doRemove(Set<Long> saids) throws SQLException {
        //调用父类AbstractDAO中的方法实现批量删除
        return handleRemove("storage_apply","said",saids) ;
    }

    @Override
    public Storage_apply findById(Long said) throws SQLException {
        String sql = "SELECT said,mid,title,pid,cid,wiid,wid,note,outorin,submit_status,audit_status,appmid FROM storage_apply WHERE said=? " ;
        super.pstmt = super.conn.prepareStatement(sql) ;

        super.pstmt.setLong(1,said);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,Storage_apply.class) ;
    }


    @Override
    public Storage_apply findByMemberAndId(int outorin,String mid,Long said) throws SQLException {
        String sql = "SELECT said,mid,title,pid,cid,wiid,wid,note,outorin,submit_status,audit_status,appmid FROM storage_apply WHERE outorin=? AND mid =? AND said=? " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1,outorin);
        super.pstmt.setString(2,mid);
        super.pstmt.setLong(3,said);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,Storage_apply.class) ;
    }

    @Override
    public List<Storage_apply> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Storage_apply> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Storage_apply> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public List<Storage_apply> findSplitByMember(int outorin,String mid, Long currentPage, Integer lineSize) throws SQLException {


        String sql = "SELECT said,mid,title,pid,cid,wiid,wid,note,outorin,submit_status,audit_status,appmid FROM storage_apply WHERE outorin=? AND mid=? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1,outorin);
        super.pstmt.setString(2,mid);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Storage_apply.class) ;



    }

    @Override
    public List<Storage_apply> findSplitByMember(int outorin,String mid, Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {


        String sql = "SELECT said,mid,title,pid,cid,wiid,wid,note,outorin,submit_status,audit_status,appmid FROM storage_apply WHERE outorin=? AND mid=? AND " + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1,outorin);
        super.pstmt.setString(2,mid);
        super.pstmt.setString(3,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Storage_apply.class) ;
    }

    @Override
    public Long getAllCountByMember(int outorin, String mid) throws SQLException {
        String sql = "SELECT COUNT(*) FROM storage_apply WHERE outorin=? AND mid=?"  ;
        this.pstmt = this.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1,outorin);
        super.pstmt.setString(2,mid);
        ResultSet rs = this.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L ;

    }

    @Override
    public Long getAllCountByMember(int outorin, String mid, String column, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM storage_apply WHERE outorin=? AND mid=? AND " + column + " LIKE ?" ;
        this.pstmt = this.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1,outorin);
        super.pstmt.setString(2,mid);
        this.pstmt.setString(3,"%"+keyWord+"%");
        ResultSet rs = this.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L ;
    }

    @Override
    public List<Storage_apply> findSplitByOutInAndSmt(int outorin, int smt, int aud, Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT said,mid,title,pid,cid,wiid,wid,note,outorin,submit_status,audit_status,appmid FROM storage_apply WHERE outorin=? AND submit_status=? AND audit_status=? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1,outorin);
        super.pstmt.setInt(2,smt);
        super.pstmt.setInt(3,aud);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Storage_apply.class) ;
    }

    @Override
    public List<Storage_apply> findSplitByOutInAndSmt(int outorin, int smt, int aud, Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "SELECT said,mid,title,pid,cid,wiid,wid,note,outorin,submit_status,audit_status,appmid FROM storage_apply WHERE outorin=? AND submit_status=? AND audit_status=? AND " + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1,outorin);
        super.pstmt.setInt(2,smt);
        super.pstmt.setInt(3,aud);
        super.pstmt.setString(4,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,Storage_apply.class) ;
    }

    @Override
    public Long getAllCountByOutInAndSmtr(int outorin, int smt,int aud) throws SQLException {
        String sql = "SELECT COUNT(*) FROM storage_apply WHERE outorin=? AND submit_status=? AND audit_status=?"  ;
        this.pstmt = this.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1,outorin);
        super.pstmt.setInt(2,smt);
        super.pstmt.setInt(3,aud);
        ResultSet rs = this.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L ;
    }

    @Override
    public Long getAllCountByOutInAndSmtr(int outorin, int smt, int aud, String column, String keyWord) throws SQLException {
        String sql = "SELECT COUNT(*) FROM storage_apply WHERE outorin=? AND submit_status=? AND audit_status=? AND " + column + " LIKE ?" ;
        this.pstmt = this.conn.prepareStatement(sql) ;
        super.pstmt.setInt(1,outorin);
        super.pstmt.setInt(2,smt);
        super.pstmt.setInt(3,aud);
        this.pstmt.setString(4,"%"+keyWord+"%");
        ResultSet rs = this.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return 0L ;
    }

    @Override
    public Long findLastId() throws SQLException {
        return super.getLastId() ;
    }
}
