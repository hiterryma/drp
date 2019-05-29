package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IGoodsDAO;
import com.yootk.vo.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class GodsDAOImpl extends AbstractDAO implements IGoodsDAO {
    @Override
    public boolean doCreate(Goods goods) throws SQLException {
        return false;
    }

    @Override
    public boolean doEdit(Goods goods) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Goods findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Goods> findAll() throws SQLException {
        List<Goods> all = new ArrayList<>();
        String sql = "SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder FROM goods WHERE delflag=0 LIMIT 12";
        super.pstmt = super.conn.prepareStatement(sql);
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Goods> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount() throws SQLException {
        return null;
    }

    @Override
    public Long getAllCount(String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public List<Goods> findByStid(Long stid) throws SQLException {
        List<Goods> all = new ArrayList<>();
        String sql = "SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder FROM goods WHERE delflag=0 AND stid=? LIMIT 12";
        super.pstmt = super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,stid);
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }
}
