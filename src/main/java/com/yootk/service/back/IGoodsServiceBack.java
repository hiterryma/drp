package com.yootk.service.back;

import com.yootk.vo.Goods;

import java.util.List;
import java.util.Map;

public interface IGoodsServiceBack {
    /**
     *   根据商品的ID查询该商品的详细信息
     * @param gid 商品ID
     * @return 返回商品的详细信息
     * @throws Exception
     */
    public Goods getById(Long gid)throws Exception;
    /**
     * 查询所有的二级子分类商品
     * @param stid
     * @return
     * @throws Exception
     */
    public Map<String, Object> getByStid(Long stid,Long currentPage,Integer lineSize,String clonum,String keyword) throws Exception;
}
