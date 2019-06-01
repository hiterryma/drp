package com.yootk.service.back;

import com.yootk.vo.Dept;

import java.util.Map;

public interface IDeptServiceBack {

    public boolean edit(Dept dept) throws Exception ;

    public Map<String,Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception ;
}
