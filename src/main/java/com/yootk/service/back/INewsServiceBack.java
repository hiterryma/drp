package com.yootk.service.back;


import com.yootk.vo.News;

import java.util.Map;
import java.util.Set;

public interface INewsServiceBack{
    /**
     * 公告添加
     * @param vo 要添加的公告内容
     * @return 添加成功返回true
     * @throws Exception
     */
    public boolean add(News vo) throws Exception ;

    public boolean edit(News vo) throws Exception ;

    public boolean editForPublish(Long aLong) throws Exception ;

    public boolean delete(Set<Long> longs) throws Exception ;

    public News get(Long nid) throws Exception ;

    public Map<String,Object> list(Long currentPage, Integer lineSize,String column,String keyword) throws Exception ;
}
