package com.yootk.service.front;

import com.yootk.vo.Address;
import com.yootk.vo.Orders;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IOrderServiceFront {
    /**
     * 根据订单的编号查询此订单的详细内容
     * @param oid 要查询的订单编号
     * @return 订单详情显示的时候需要如下的数据内容：
     * 1、key = orders、value = 订单的Orders对象；
     * 2、key = details、value = 订单详情内容，包含了（gid=amount）的Map集合；
     * 3、key = allGoods、value = 与此订单有关的商品内容
     * @throws Exception 数据层异常
     */
    public Map<String,Object> getDetails(Long oid) throws Exception ;

    public Map<String,Object> list(String mid,Long currentPage,Integer lineSize) throws Exception ;

    /**
     * 根据用户编号和商品编号的集合查询出所有购买的商品内容
     * @param mid 当前用户编号
     * @param gids 要显示的商品编号
     * @return 返回如下的信息内容
     * 1.key=shopcar,value=(Map)保存商品编号和购买数量的对应关系；
     * 2.key=allGoods,value=(List)保存所有的要购买的商品信息；
     * 3.key=allProvinces,value=(List)保存所有的省份数据
     * @throws Exception 数据层异常
     */
    public Map<String,Object> preAdd(String mid, Set<Long> gids)throws Exception;

    /**
     * 实现用户订单的创建工作。该操作需要执行如下的业务处理：
     * 1.新创建的订单的日期肯定为当前的日期
     * 2.订单的总价肯定要通过购物车和商品的单价进行计算
     * 3.进行订单信息的保存，同时返回有当前的订单id
     * 4.利用此订单id创建相应的Details实例，并且将其保存在数据库里面
     * 5.删除相应的购物车的数据信息
     * @param orders 要创建订单的基本信息
     * @param gids 订单包含的商品信息
     * @return 订单创建成功返回true
     * @throws Exception 数据层异常
     */
    public boolean add(Orders orders,Set<Long> gids)throws Exception;

    /**
     * 创建用户订单
     * @param aid 地址id
     * @param gids 商品id数组
     * @param note 备注信息
     * @return 创建成功返回true
     * @throws Exception 数据层异常
     */
    public boolean add(String aid, Set<Long> gids ,String note)throws Exception;
    /**
     * 保存订单详情信息
     * @param gids 此订单中的所有商品id所在的集合
     * @return 添加成功返回true
     * @throws Exception 数据层异常
     */
    public boolean addDetails(Set<Long> gids)throws Exception;

    /**
     * 获得全部的address信息
     * @return 返回地址信息的List集合
     * @throws Exception 数据层异常
     */
    public List<Address> findAllAdress() throws Exception;
}
