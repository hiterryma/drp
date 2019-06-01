package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IAddressDAO;
import com.yootk.vo.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Repository
public class AddressDAOImpl extends AbstractDAO implements IAddressDAO {

    @Override
    public boolean doCreate(Address address) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Address address) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Address findById(Long adid) throws SQLException {
        Address address=null;
        String sql="select adid,mid,cid,pid,addr,receiver,phone from address where adid=? and dflag=0";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,adid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            address=new Address();
            address.setAdid(rs.getLong(1));
            address.setMid(rs.getString(2));
            address.setCid(rs.getInt(3));
            address.setPid(rs.getInt(4));
            address.setAddr(rs.getString(5));
            address.setReceiver(rs.getString(6));
            address.setPhone(rs.getString(7));
        }
        return address;
    }

    @Override
    public List<Address> findAll() throws SQLException {
        List<Address> Alladdress=new ArrayList<>();
        String sql="select adid,mid,cid,pid,addr,receiver,phone from address where dflag=0";
        super.pstmt=super.conn.prepareStatement(sql);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            Address address=new Address();
            address.setAdid(rs.getLong(1));
            address.setMid(rs.getString(2));
            address.setCid(rs.getInt(3));
            address.setPid(rs.getInt(4));
            address.setAddr(rs.getString(5));
            address.setReceiver(rs.getString(6));
            address.setPhone(rs.getString(7));
            Alladdress.add(address);
        }
        return Alladdress;
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
