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
public class GoodsImpl extends AbstractDAO implements IGoodsDAO {
    @Override
    public List<Goods> findAllByGids(Set<Long> gids) throws SQLException {
        StringBuffer sql = new StringBuffer("SELECT gid,name,wiid,stid,price,weight,photo,note,lastin,stornum,recorder FROM goods WHERE delflag=0 and gid IN ( ") ;
        for (Long gid : gids) {
            sql.append(gid).append(",") ;
        }
        sql.delete(sql.length() - 1,sql.length()).append(")") ;
        List<Goods> all = new ArrayList<>();
        super.pstmt = super.conn.prepareStatement(sql.toString());
        return super.handleResultToList(super.pstmt.executeQuery(),Goods.class);
    }

    @Override
    public Double findPriceByGid(Long gid) throws SQLException {
        String sql="select price from goods where gid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,gid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getDouble(1);
        }
        return null;
    }

    @Override
    public Long getAllCountByStid(Long stid) throws SQLException {
        return null;
    }

    @Override
    public Long getAllCountByStid(Long stid, String column, String keyWord) throws SQLException {
        return null;
    }

    @Override
    public List<Goods> findByStid(Long stid, Long currentPage, Integer lineSize, String clonum, String keyword) throws SQLException {
        return null;
    }

    @Override
    public List<Goods> findByStid(Long stid, Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

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
        return null;
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
}
