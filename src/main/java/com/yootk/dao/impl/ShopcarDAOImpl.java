package com.yootk.dao.impl;

import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IShopcarDAO;
import com.yootk.vo.Shopcar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Repository //注解数据层
public class ShopcarDAOImpl extends AbstractDAO implements IShopcarDAO {
    @Override
    public boolean doCreate(Shopcar shopcar) throws SQLException {
        String sql="insert into shopcar (mid,gid,amount)values(?,?,?)";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,shopcar.getMid());
        super.pstmt.setLong(2,shopcar.getGid());
        super.pstmt.setInt(3,shopcar.getAmount());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEdit(Shopcar shopcar) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Shopcar findById(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Shopcar> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Shopcar> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Shopcar> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
    public Integer findAmountByMemberAndGoods(String mid, Long gid) throws SQLException {
        String sql="select amount from shopcar where mid=? and gid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        super.pstmt.setLong(2,gid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return null;
    }

    @Override
    public boolean doEditAmountByMemberAndGoods(String mid, Long gid, Integer amount) throws SQLException {
        String sql="update shopcar set amount=? where mid=? and gid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setInt(1,amount);
        super.pstmt.setString(2,mid);
        super.pstmt.setLong(3,gid);
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public Map<Long, Integer> findAllByMember(String mid) throws SQLException {
        Map<Long,Integer> map=new HashMap<>();
        String sql="select gid,amount from shopcar where mid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,mid);
        ResultSet rs=super.pstmt.executeQuery();
        while(rs.next()){
            map.put(rs.getLong(1),rs.getInt(2));//保存商品编号和对应数量
        }
        return map;
    }
}
