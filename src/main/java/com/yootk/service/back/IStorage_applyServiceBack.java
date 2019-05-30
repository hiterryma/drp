package com.yootk.service.back;

import java.util.Map;

public interface IStorage_applyServiceBack  {
    /**
     * 执行出入库申请单添加前的处理操作
     * 主要是查询出省份、仓库类型并返回
     * @return
     * @throws Exception
     */
    public Map<String,Object> preAdd() throws Exception ;
}
