package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Address;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public interface IAddressDAO extends IBaseDAO<Long , Address> {
    //根据客户姓名查找所有客户地址信息
    public List<Address> findAll(String mid) throws SQLException ;

    public boolean doCreate(Address address) throws SQLException ;

    public boolean doRemoveByAddress(String mid,Set<Long> adids) throws  SQLException ;

    public boolean doEdit(Address address,Long adid) throws SQLException ;

    /**
     * 根据地址id查询全部的地址信息
     * @param adid 地址id
     * @return 返回全部的地址信息
     * @throws SQLException jdbc
     */
    public Address findByAdid(Long adid)throws SQLException;


}
