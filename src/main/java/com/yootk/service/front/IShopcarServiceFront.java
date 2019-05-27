package com.yootk.service.front;

import com.yootk.vo.Shopcar;

public interface IShopcarServiceFront {
    /**
     * 实现购物车数据的添加操作，在进行添加的时候如果指定的内容已经添加成功则需要数据的更新处理
     * @param vo 包含有mid，gid
     * @return 保存成功返回true，否则返回false
     * @throws Exception 数据层异常
     */
    public boolean add(Shopcar vo)throws Exception;
}
