package com.yootk.service.back;

import com.yootk.vo.Audit;
import com.yootk.vo.Storage_apply;

import java.util.Map;

public interface IAuditServiceBack  {
    /**
     * 根据清单编号执行审核前的数据显示
     * @param said
     * @return
     * @throws Exception
     */
    public Map<String,Object> preAdd(Long said) throws Exception;

    /**
     * 执行审核处理：修改申请单的审核字段、创建审核信息
     * @param storage_apply
     * @param audit
     * @return
     * @throws Exception
     */
    public boolean audit(Long said, Audit audit) throws Exception ;

    /**
     * 执行用户查询前的处理，查到跳转显示页面，没有就还在本页面
     * @param said
     * @return
     * @throws Exception
     */
    public boolean preSearch(Long said) throws Exception ;
}
