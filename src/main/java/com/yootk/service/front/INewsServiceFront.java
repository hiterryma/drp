package com.yootk.service.front;


import com.yootk.vo.News;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface INewsServiceFront {

    public List<News> getListForIndex() throws Exception ;
    public Map<String,Object> list(Long currentPage, Integer lineSize,String column,String keyword) throws Exception ;
}
