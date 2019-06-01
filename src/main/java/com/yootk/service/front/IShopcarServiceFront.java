package com.yootk.service.front;

import com.yootk.vo.Shopcar;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IShopcarServiceFront {
    /**
     * 实现购物车数据的添加操作，在进行添加的时候如果指定的内容已经添加成功则需要数据的更新处理
     * @param vo 包含有mid，gid
     * @return 保存成功返回true，否则返回false
     * @throws Exception 数据层异常
     */
    public boolean add(Shopcar vo)throws Exception;

    /**
     * 根据用户编号列出购物车之中的全部数据信息
     * @param mid 用户编号
     * @return 所有的购物车信息通过Map集合描述，返回的内容包括如下信息
     * 1.key=allGoods,value=商品信息内容
     * 2.key=shopcar,value=购物车信息的Map集合
     * @throws Exception SQL
     */
    public Map<String,Object> listByMember(String mid)throws Exception;

    /**
     * 进行数据库中购物车信息的批量修改操作
     * @param cars 要修改的数据信息
     * @return 修改成功返回true，否则返回false
     * @throws Exception 异常
     */
    public boolean editBatch(List<Shopcar> cars)throws Exception;

    /**
     * 根据用户的编号和商品编号删除相应的购物车信息
     * @param mid 用户编号
     * @param gids 商品编号
     * @return 删除成功返回true
     * @throws Exception 数据层异常
     */
    public boolean deleteByMember(String mid,Set<Long> gids)throws Exception;

    /**
     * 根据用户id和商品id查找对应id商品的数量
     * @param mid 用户id
     * @param gid 商品ID
     * @return 返回查找到的数量，没有返回null‘
     * @throws SQLException 数据层异常
     */
    public Integer findAmount(String mid,Long gid)throws SQLException;
}
