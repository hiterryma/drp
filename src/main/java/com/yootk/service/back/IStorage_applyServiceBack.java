package com.yootk.service.back;

import com.yootk.vo.Storage_apply;

import java.util.Map;

public interface IStorage_applyServiceBack  {
    /**
     * 执行出入库申请单添加前的处理操作
     * 主要是查询出省份、仓库类型并返回
     * @return
     * @throws Exception
     */
    public Map<String,Object> preAdd() throws Exception ;

    /**
     * 执行出入库申请单的创建
     * @param storage_apply
     * @return
     * @throws Exception
     */
    public boolean add(Storage_apply storage_apply) throws Exception ;

    /**
     * 实现申请单的分页显示、分页查询
     * @param currentPage
     * @param lineSize
     * @param column
     * @param keyWord
     * @return
     * @throws Exception
     */
    public Map<String, Object> list(int outorin, String mid, Long currentPage, Integer lineSize, String column, String keyWord) throws Exception;
}
