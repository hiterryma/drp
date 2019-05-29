package com.yootk.service.back;

import com.yootk.vo.Goods;
import com.yootk.vo.Subtype;
import com.yootk.vo.Witem;

import java.util.List;
import java.util.Map;

public interface IWitemServiceBack {
    /**
     * 查询所有的商品分类信息
     * @return
     * @throws Exception
     */
    public Map<String ,Object> getAll() throws Exception;
}
