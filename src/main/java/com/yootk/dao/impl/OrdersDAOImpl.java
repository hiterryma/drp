package com.yootk.dao.impl;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Repository;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.IGoodsDAO;
import com.yootk.dao.IOrdersDAO;
import com.yootk.dao.IShopcarDAO;
import com.yootk.vo.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
@Repository
public class OrdersDAOImpl extends AbstractDAO implements IOrdersDAO {
    @Override
    public Long findLastId() throws SQLException {
        return super.getLastId();
    }

    @Override
    public List<Orders> findSplitByMember(String mid, Long currentPage, Integer lineSize) throws SQLException {
        String sql = "SELECT oid,mid,adid,subdate,price,note FROM orders WHERE mid=? ORDER BY subdate DESC LIMIT " + (currentPage - 1) * lineSize + "," + lineSize ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,mid);
        return super.handleResultToList(super.pstmt.executeQuery(),Orders.class);
    }

    @Override
    public Long getAllCountByMember(String mid) throws SQLException {
        String sql = "SELECT COUNT(*) FROM orders WHERE mid=?" ;
        super.pstmt = super.conn.prepareStatement(sql) ;
        super.pstmt.setString(1,mid);
        ResultSet rs = super.pstmt.executeQuery() ;
        if (rs.next()) {
            return rs.getLong(1) ;
        }
        return null;
    }

    @Override
    public boolean doCreate(String aid, Set<Long> gids,String note) throws SQLException {
        IGoodsDAO goodsDAO=new GoodsImpl();
        IShopcarDAO shopcarDAO=new ShopcarDAOImpl();
        Double danJia=null; //此价格为一种商品的单价
        Integer amount=null;//此数量为一种商品所购买的数量
        Double price=0.0;
        //接下来需要算出总价，
        for(Long gid:gids){
            amount=shopcarDAO.findAmountByMemberAndGoods(AbstractAction.getFrontUser(),gid);
            danJia=goodsDAO.findPriceByGid(gid);//需要先获取每一种商品对应的数量，然后偶求出这种商品的总价，再将各种商品的总价加一起
            price+=amount*danJia;//此价格为一张订单上所有商品的总价
        }
        String sql="insert into orders (mid,adid,subdate,price,note)values(?,?,now(),?,?)";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,AbstractAction.getFrontUser());
        super.pstmt.setInt(2,Integer.parseInt(aid));
        super.pstmt.setDouble(3,price);
        super.pstmt.setString(4,note);
        return super.pstmt.executeUpdate()>0;
    }


    @Override
    public boolean doCreate(Orders orders) throws SQLException {
        //下面的adid为配送地址id
        String sql="insert into orders(mid,adid,subdate,price,note)values(?,?,?,?,?)";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setString(1,orders.getMid());
        super.pstmt.setInt(2,orders.getAdid());
        super.pstmt.setDate(3,new java.sql.Date(orders.getSubdate().getTime()));
        super.pstmt.setDouble(4,orders.getPrice());
        super.pstmt.setString(5,orders.getNote());
        return super.pstmt.executeUpdate()>0;
    }

    @Override
    public boolean doEdit(Orders orders) throws SQLException {
        return false;
    }

    @Override
    public boolean doRemove(Set<Long> longs) throws SQLException {
        return false;
    }

    @Override
    public Orders findById(Long oid) throws SQLException {//覆写此方法,根据订单id查询出订单
        Orders orders=null;
        String sql="select oid,mid,adid,subdate,price,note from orders where oid=?";
        super.pstmt=super.conn.prepareStatement(sql);
        super.pstmt.setLong(1,oid);
        ResultSet rs=super.pstmt.executeQuery();
        if(rs.next()){
            orders=new Orders();
            orders.setOid(rs.getLong(1));
            orders.setMid(rs.getString(2));
            orders.setAdid(rs.getInt(3));
            orders.setSubdate(rs.getDate(4));
            orders.setPrice(rs.getDouble(5));
            orders.setNote(rs.getString(6));
        }
        return orders;
    }

    @Override
    public List<Orders> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Orders> findSplit(Long currentPage, Integer lineSize) throws SQLException {
        return null;
    }

    @Override
    public List<Orders> findSplit(Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException {
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
