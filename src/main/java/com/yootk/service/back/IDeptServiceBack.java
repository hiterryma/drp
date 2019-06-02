package com.yootk.service.back;

import com.yootk.vo.Dept;
import com.yootk.vo.Member;

import java.util.List;
import java.util.Map;

public interface IDeptServiceBack {

    public boolean edit(Dept dept) throws Exception ;

    public Map<String,Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception ;

    public List<Dept> list() throws Exception;

    public Map<String, Object> ListMemberbyDept(Long did, Long currentPage, Integer lineSize) throws Exception;
}
