package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.INewsDAO;
import com.yootk.vo.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class NewsDAOImpl extends AbstractDAO implements INewsDAO {
    @Override
    public boolean doCreate(News news) throws SQLException {
        String sql = "insert into news(title,abs,photo,note) values(?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,news.getTitle());
        super.pstmt.setString(2,news.getAbs());
        super.pstmt.setString(3,news.getPhoto());
        super.pstmt.setString(4,news.getNote());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEdit(News news) throws SQLException {
        String sql = "update news set title=?,abs=?,photo=?,note=? where nid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,news.getTitle());
        super.pstmt.setString(2,news.getAbs());
        super.pstmt.setString(3,news.getPhoto());
        super.pstmt.setString(4,news.getNote());
        super.pstmt.setLong(5,news.getNid());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        String sql = "delete news where nid = ?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;

        for(Long along:longs){
            super.pstmt.setLong(1,along);
            super.pstmt.addBatch();
        }
        return super.handleRemove("news","nid",longs);
    }

    @Override
    public News findById(Long alone) throws SQLException {
        String sql = "select nid,title,abs,photo,note from news where nid =?" ;
        super.pstmt = super.conn.prepareStatement(sql );
        super.pstmt.setLong(1,alone);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,News.class);
    }

    @Override
    public List<News> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<News> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "select nid,title,abs,photo,note from news limit " + (currentPage-1)*lineSize + "," + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql );
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,News.class);
    }

    @Override
    public List<News> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "select nid,title,abs,photo,note from news where "+column+" = ?  limit " + (currentPage-1)*lineSize + "," + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql );
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,News.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
       String sql = "select count(*) form news " ;
       super.pstmt = super.conn.prepareStatement(sql) ;
       ResultSet rs = super.pstmt.executeQuery();
       if(rs.next()){
           return rs.getLong(1) ;
       }
       return 0L;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        String sql = "select count(*) form news where "+column+" = ?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getLong(1) ;
        }
        return 0L;
    }
}
