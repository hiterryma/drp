package com.yootk.service.back;

import com.yootk.vo.Goods;

import java.util.Map;

public interface IGoodsService {

    public Map<String, Object> preAdd() throws Exception;

    public boolean add(Goods goods) throws Exception;

    public Map<String, Object> preEdit(Long gid) throws Exception;

    public boolean edit(Goods goods) throws Exception;

    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception;

}
