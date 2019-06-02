package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.ICustomerRecordDAO;
import com.yootk.vo.Customer;
import com.yootk.vo.CustomerRecord;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Repository
public class CustomRecordDAOImpl extends AbstractDAO implements ICustomerRecordDAO {
    @Override
    public boolean doCreate(CustomerRecord customerRecord) throws SQLException {
        String sql = "insert into customer_record (cmid, cdate, criid, cuid, note,title) values (?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,customerRecord.getCmid());
        super.pstmt.setDate(2,new java.sql.Date(new Date().getTime()));
        super.pstmt.setLong(3,customerRecord.getCriid());
        super.pstmt.setLong(4,customerRecord.getCuid());
        super.pstmt.setString(5,customerRecord.getNote());
        super.pstmt.setString(6,customerRecord.getTitle());
        try{
            return super.pstmt.executeUpdate() > 0 ;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false ;
    }

    @Override
    public boolean doEdit(CustomerRecord customerRecord) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public CustomerRecord findById(Long aLong) throws SQLException {
        return  null ;
    }

    @Override
    public List<CustomerRecord> findAll() throws SQLException {
        return null ;
    }

    @Override
    public List<CustomerRecord> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null ;
    }

    @Override
    public List<CustomerRecord> findSplit(Long currentPage, Integer lineSize, String column, String value) throws SQLException {
        String sql = "select crid,cmid, cdate, criid, cuid, note,title from customer_record where "+column+" = ?  limit " + (currentPage-1)*lineSize+","+ lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,value);
        ResultSet rs = super.pstmt.executeQuery();
        return super.handleResultToList(rs,CustomerRecord.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
        String sql = "select count(*) from customer_record" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return  rs.getLong(1);
        }
        return 0L ;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        String sql = "select count(*) from customer_record  where "+column+" = ? " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,keyWord);
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return  rs.getLong(1);
        }
        return 0L ;
    }
}
