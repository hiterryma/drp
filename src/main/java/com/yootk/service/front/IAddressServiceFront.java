package com.yootk.service.front;

import com.yootk.common.annotation.Service;
import com.yootk.vo.Address;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public interface IAddressServiceFront {

    public Map<String,Object> preAdd() throws Exception ;

    public boolean add(Address address) throws Exception ;

    public Map<String ,Object> list(String mid) throws Exception ;

    public boolean deleteByAddress(String mid, Set<Long> adids) throws SQLException;

    public boolean edit(Address address,Long adid) throws SQLException ;

    public Map<String,Object> preEdit(Long adid) throws Exception ;

}
