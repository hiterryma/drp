package com.yootk.service.back;


import com.yootk.vo.News;

import java.util.Map;

public interface INewsServiceBack{
    /**
     * 公告添加
     * @param vo 要添加的公告内容
     * @return 添加成功返回true
     * @throws Exception
     */
    public boolean add(News vo) throws Exception ;

    public boolean edit(News vo) throws Exception ;

    public News get(Long mid) throws Exception ;

    public Map<String,Object> split(Long currentPage, Integer lineSize,String column,String keyword) throws Exception ;
}
