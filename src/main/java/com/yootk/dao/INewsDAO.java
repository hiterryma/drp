package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.News;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface INewsDAO  extends IBaseDAO<Long, News> {

    @Override
    public boolean doCreate(News news) throws SQLException;

    @Override
    public boolean doEdit(News news) throws SQLException;

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException;

    @Override
    public News findById(Long aLong) throws SQLException;

    @Override
    public List<News> findSplit(Long currentPage, Integer lineSize) throws SQLException;

    @Override
    public  List<News> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException;

    @Override
    public Long getAllCount() throws SQLException;

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException;
}
