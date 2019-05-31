package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IGoodsDAO;
import com.yootk.vo.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Repository
public class GoodsDAOImpl extends AbstractDAO implements IGoodsDAO {
    @Override
    public boolean doCreate(Goods goods) throws SQLException {
        String sql = "insert into goods (name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag) values (?,?,?,?,?,?,?,?,?,?,?)";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, goods.getName());
        super.pstmt.setLong(2, goods.getWiid());
        super.pstmt.setLong(3, goods.getStid());
        super.pstmt.setDouble(4, goods.getPrice());
        super.pstmt.setDouble(5, goods.getWeight());
        super.pstmt.setString(6, goods.getPhoto());
        super.pstmt.setString(7, goods.getNote());
        super.pstmt.setTimestamp(8, new Timestamp(goods.getLastin().getTime()));
        super.pstmt.setInt(9, goods.getStornum());
        super.pstmt.setString(10, goods.getRecorder());
        super.pstmt.setInt(11, goods.getDelflag());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doEdit(Goods goods) throws SQLException {
        String sql = "update goods set name=?,wiid=?,stid=?,price=?,weight=?,photo=?,note=?,recorder=? where gid=?";
        super.pstmt = this.conn.prepareStatement(sql);
        super.pstmt.setString(1, goods.getName());
        super.pstmt.setLong(2, goods.getWiid());
        super.pstmt.setLong(3, goods.getStid());
        super.pstmt.setDouble(4, goods.getPrice());
        super.pstmt.setDouble(5, goods.getWeight());
        super.pstmt.setString(6, goods.getPhoto());
        super.pstmt.setString(7, goods.getNote());
        super.pstmt.setString(8, goods.getRecorder());
        super.pstmt.setLong(9, goods.getGid());
        return super.pstmt.executeUpdate() > 0;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Goods findById(Long aLong) throws SQLException {
        String sql = "select gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag from goods where gid=?";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1, aLong);
        return super.handleResultToVO(super.pstmt.executeQuery(), Goods.class);
    }

    @Override
    public List<Goods> findAll() throws SQLException {
        String sql = "SELECT name,price,photo FROM goods WHERE delflag=0  LIMIT 12";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        String sql = "select gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag from goods limit " + (currentPage - 1) * lineSize + " , " + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);


        return super.handleResultToList(super.pstmt.executeQuery(), Goods.class);
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        String sql = "select gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder,delflag from goods where " + column + " like ?  limit " + (currentPage - 1) * lineSize + " , " + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setString(1, "%" + keyWord + "%");
        return super.handleResultToList(super.pstmt.executeQuery(), Goods.class);
    }

    @Override
    public Long getAllCount() throws SQLException {
        return super.handleCount("goods");
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return super.handleCount("goods", column, keyWord);
    }

    @Override
    public List<Goods> findByStid(Long stid,Long currentPage,Integer lineSize,String clonum,String keyword) throws SQLException {
        String sql = "SELECT name,price,photo FROM goods WHERE delflag=0 AND stid=? AND "+ clonum +" LIKE ? LIMIT " + (currentPage - 1) * lineSize + " , " + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,stid);
        super.pstmt.setString(2,"%"+keyword+"%");
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findByStid(Long stid, Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT name,price,photo FROM goods WHERE delflag=0 AND stid=?  LIMIT " + (currentPage - 1) * lineSize + " , " + lineSize;
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,stid);
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

}
