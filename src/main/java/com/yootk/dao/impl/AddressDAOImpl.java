package com.yootk.dao.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IActionDAO;
import com.yootk.dao.IAddressDAO;
import com.yootk.vo.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Repository
public class AddressDAOImpl extends AbstractDAO implements IAddressDAO {

    @Override
    public List<Address> findAll(String mid) throws SQLException {
        String sql = " SELECT adid,cid,mid,pid,addr,receiver,phone FROM address WHERE mid =? " ;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        return super.handleResultToList(super.pstmt.executeQuery(),Address.class);
    }

    @Override
    public boolean doCreate(Address address) throws SQLException {
        String sql = " INSERT INTO address(mid,receiver,phone, pid, cid, addr,dflag) VALUES (?,?,?,?,?,?,?) ";
        super.pstmt =super.conn.prepareStatement(sql);
        super.pstmt.setString(1,address.getMid());
        super.pstmt.setString(2,address.getReceiver());
        super.pstmt.setString(3,address.getPhone());
        super.pstmt.setLong(4,address.getPid());
        super.pstmt.setLong(5,address.getCid());
        super.pstmt.setString(6,address.getAddr());
        super.pstmt.setInt(7,0);
        Boolean flag  = false ;
        try{

            flag = super.pstmt.executeUpdate() >0 ;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag ;
    }

    @Override
    public boolean doRemoveByAddress(String mid, Set<Long> adids) throws SQLException {
        StringBuffer sql =new StringBuffer("DELETE FROM address WHERE mid=? AND adid in (");
        for (Long adid : adids) {
            sql.append(adid).append(",") ;
        }
        sql.delete(sql.length() -1,sql.length()).append(")");
        super.pstmt = super.conn.prepareStatement(sql.toString());
        super.pstmt.setString(1,mid);
        return super.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doEdit(Address address) throws SQLException {
        String sql = "UPDATE address SET mid=?,cid=?,pid=?,addr=?,receiver=?,phone=?,dflag=？ WHERE adid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,address.getMid());
        super.pstmt.setLong(2,address.getCid());
        super.pstmt.setLong(3,address.getPid());
        super.pstmt.setString(4,address.getAddr());
        super.pstmt.setString(5,address.getReceiver());
        super.pstmt.setString(6,address.getPhone());
        super.pstmt.setInt(7,0);
        System.out.println(address.getPhone());
        System.out.println(address.getReceiver());
        System.out.println(address.getMid());
        System.out.println(address.getPid());
        System.out.println(address.getAddr());
        System.out.println(address.getAdid());
        System.out.println(super.pstmt.executeUpdate());
        return super.pstmt.executeUpdate() > 0 ;
    }



    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Address findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Address> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Address> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Address> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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


