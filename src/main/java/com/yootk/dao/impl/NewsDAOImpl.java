package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.INewsDAO;
import com.yootk.vo.News;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public class NewsDAOImpl extends AbstractDAO implements INewsDAO {
    @Override
    public boolean doCreate(News news) throws SQLException {
        String sql = "insert into news(title,abs,photo,note,mid,pubdate,status) values(?,?,?,?,?,?,?)" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,news.getTitle());
        super.pstmt.setString(2,news.getAbs());
        super.pstmt.setString(3,news.getPhoto());
        super.pstmt.setString(4,news.getNote());
        super.pstmt.setString(5,news.getMid());
        super.pstmt.setTimestamp(6,new java.sql.Timestamp(new Date().getTime()));
        super.pstmt.setInt(7,news.getStatus());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEdit(News news) throws SQLException {
        String sql = "update news set title=?,abs=?,photo=?,note=?,mid=?,pubdate=?,status=?  where nid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,news.getTitle());
        super.pstmt.setString(2,news.getAbs());
        super.pstmt.setString(3,news.getPhoto());
        super.pstmt.setString(4,news.getNote());
        super.pstmt.setString(5,news.getMid());
        super.pstmt.setDate(6,new java.sql.Date(new Date().getTime()));
        super.pstmt.setInt(7,news.getStatus());
        super.pstmt.setLong(8,news.getNid());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEditForPublish(Long along) throws SQLException {
        String sql = "update news set  status=1  where nid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setLong(1,along);
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        String sql = "delete from news where nid = ?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        for(Long along:longs){
            super.pstmt.setLong(1,along);
            super.pstmt.addBatch();
        }
        return  super.isBatchSuccess( super.pstmt.executeBatch() );
    }

    @Override
    public News findById(Long alone) throws SQLException {
        String sql = "select nid,title,abs,photo,note,mid,pubdate,status from news where nid =?" ;
        super.pstmt = super.conn.prepareStatement(sql );
        super.pstmt.setLong(1,alone);
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToVO(rs,News.class);
    }

    @Override
    public List<News> findAll() throws SQLException {
        String sql = "select nid,title,abs,photo,note,mid,pubdate,status from news";
        super.pstmt = super.conn.prepareStatement(sql );
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,News.class);
    }

    @Override
    public List<News> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "select nid,title,abs,photo,note,mid,pubdate,status from news  LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql );
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,News.class);
    }

    @Override
    public List<News> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "select nid,title,abs,photo,note,mid,pubdate,status from news WHERE " + column + " LIKE ? LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql );
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,News.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
       String sql = "select count(*) from news " ;
       super.pstmt = super.conn.prepareStatement(sql) ;
       ResultSet rs = super.pstmt.executeQuery();
       if(rs.next()){
           return rs.getLong(1) ;
       }
       return 0L;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        String sql = "select count(*) from news where "+column+" like ?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,"%"+keyWord+"%");
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getLong(1) ;
        }
        return 0L;
    }

    @Override
    public List<News> findAllForIndex() throws SQLException {
        String sql = "select nid,title,abs,pubdate from news where status = 1 order by pubdate desc limit 0,10;";
        super.pstmt = super.conn.prepareStatement(sql );
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,News.class);
    }

    @Override
    public List<News> findSplitForFront(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "select nid,title,abs,photo,note,mid,pubdate,status from news where status=1  LIMIT " + (currentPage - 1) * lineSize + "," + lineSize;
        super.pstmt = super.conn.prepareStatement(sql );
        ResultSet rs = super.pstmt.executeQuery() ;
        return super.handleResultToList(rs,News.class);
    }

    @Override
    public Long getAllCountForFront() throws SQLException {
        String sql = "select count(*) from news where status = 1 " ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        ResultSet rs = super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getLong(1) ;
        }
        return 0L;
    }
}
