package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Storage_apply;

import java.sql.SQLException;
import java.util.List;

public interface IStorage_applyDAO extends IBaseDAO<Long, Storage_apply> {
    /**
     * 获取最后一次插入的申请单id
     * @return
     * @throws SQLException
     */
    public Long findLastId() throws SQLException ;

    /**
     * 根据出入库标记、用户id，申请单id查询申请单
     * @param outorin
     * @param mid
     * @param said
     * @return
     * @throws SQLException
     */
    public Storage_apply findByMemberAndId(int outorin,String mid,Long said) throws SQLException ;

    /**
     * 根据登录用户的id，实现分页
     * @param outorin
     * @param mid
     * @param currentPage
     * @param lineSize
     * @return
     * @throws SQLException
     */
    public List<Storage_apply> findSplitByMember(int outorin, String mid, Long currentPage, Integer lineSize) throws SQLException ;

    /**
     * 根据登录用户编号，实现分页查询
     * @param outorin
     * @param mid
     * @param currentPage
     * @param lineSize
     * @param column
     * @param keyWord
     * @return
     * @throws SQLException
     */
    public List<Storage_apply> findSplitByMember(int outorin,String mid, Long currentPage, Integer lineSize, String column, String keyWord) throws SQLException ;

    /**
     * 根据用户id，查询记录总数
     * @param outorin
     * @param mid
     * @return
     * @throws SQLException
     */
    public Long getAllCountByMember(int outorin, String mid) throws SQLException ;

    /**
     * 根据用户编号，得到分页查询的总记录数
     * @param outorin
     * @param mid
     * @param column
     * @param keyWord
     * @return
     * @throws SQLException
     */
    public Long getAllCountByMember(int outorin, String mid, String column, String keyWord) throws SQLException ;

}
