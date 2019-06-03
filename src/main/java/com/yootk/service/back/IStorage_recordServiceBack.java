package com.yootk.service.back;

import com.yootk.vo.Storage_record;

import java.util.Map;

public interface IStorage_recordServiceBack {
    /**
     * 进行入库搜索时的处理操作
     * @param said
     * @return
     * @throws Exception
     */
    public Map<String,Object> preSearch(Long said) throws Exception ;

    /**
     * 增加入库记录
     * @param storage_record
     * @return
     * @throws Exception
     */
    public boolean add(Storage_record storage_record) throws Exception ;
}
