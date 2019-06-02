package com.yootk.service.back;

import com.yootk.vo.Storage_apply_details;

import java.util.Map;

public interface IStorage_apply_detailsServiceBack {

    /**
     * 根据入库申请单编号查询出所需信息，保存在Map集合之中
     * @param said
     * @return
     * @throws Exception
     */
    public Map<String,Object> preAdd(Long said) throws Exception ;


    public boolean addOrEdit(Storage_apply_details storage_apply_details) throws Exception ;
}
