package com.yootk.service.back;

import java.util.Map;

public interface IDistributionServiceBack {
    /**
     * 执行创建出库清单前的商品显示
     * @return
     * @throws Exception
     */
    public Map<String,Object> preAdd(String salemid)throws Exception ;
}
