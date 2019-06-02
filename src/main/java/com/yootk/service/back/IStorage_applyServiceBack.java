package com.yootk.service.back;

import com.yootk.vo.Storage_apply;

import java.util.Map;
import java.util.Set;

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

    /**
     * 执行清单提交
     * @param said  清单id
     * @return
     * @throws Exception
     */
    public boolean submit(Long said) throws Exception ;

    /**
     * 执行清单修改之前的处理操作，关键是清单数据的回显，返回相关数据信息
     * @return
     * @throws Exception
     */
    public Map<String,Object> preEdit(Long said) throws Exception ;

    /**
     * 进行清单信息的修改
     * @param storage_apply
     * @return
     * @throws Exception
     */
    public boolean edit(Storage_apply storage_apply) throws Exception ;

    /**
     * 批量删除清单数据，也可单独删除
     * @param saids
     * @return
     * @throws Exception
     */
    public boolean delete(Set<Long> saids) throws Exception ;

    /**
     * 出入库清单提交之后的分页显示，供出入库审核人员查看
     * @param outorin
     * @param smt
     * @param currentPage
     * @param lineSize
     * @param column
     * @param keyWord
     * @return
     * @throws Exception
     */
    public Map<String,Object> listByOutIn(int outorin, int smt, int aud, Long currentPage, Integer lineSize, String column, String keyWord) throws Exception ;


}
