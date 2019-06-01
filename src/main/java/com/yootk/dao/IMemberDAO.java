package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Member;

import java.sql.SQLException;
import java.util.List;

public interface IMemberDAO extends IBaseDAO<String , Member> {
    /**
     * 更新最新登录时间
     * @param vo
     * @return
     * @throws SQLException
     */
    public boolean update_lastTinme(Member vo) throws SQLException;
    /**
     * 查询用户是否有部门，用户查询雇员的角色信息
     * @param mid
     * @return
     * @throws SQLException
     */
    public Member findDidByDeptAndMember(String mid) throws SQLException;
    /**
     *
     * @param newpassword
     * @param mid
     * @return
     * @throws SQLException
     */
    public boolean doEditPasswordByMember(String newpassword,String mid)throws SQLException;
    /**
     * 进行前台用户的资料修改
     * @param vo  包含要修改的用户资料
     * @return 成功返回true，否则返回false
     * @throws SQLException
     */
    public boolean doEditDatumByMember(Member vo) throws SQLException;
    /**
     * 查询前台登录用户的基本资料
     * @param mid  要查询的雇员ID
     * @return 返回雇员的信息
     * @throws SQLException
     */
    public Member findDatumByMember(String mid)throws SQLException;
    /**
     *
     * @param mid
     * @return
     * @throws SQLException
     */
    public String findMemberById(String mid) throws SQLException;
    /**
     * 查询用户是为后台用户
     * @param mid 要查询的用户ID
     * @return 返回包含查询信息的Member类
     * @throws SQLException
     */
    public Integer findTypeByMember(String mid) throws SQLException;

    /**
     * 实现用户注册
     * @param vo    包含住处的用户ID和加密后的密码
     * @return 成功返回true，否则返回false
     * @throws SQLException
     */
    public boolean doCreateByMember(Member vo) throws SQLException;

    /**
     * 用户登录验证
     * @param mid 要验证的用户ID
     * @return 返回用户信息
     * @throws SQLException
     */
    public Member findByIdAndpw(String mid) throws SQLException;

    @Override
    boolean doEdit(Member member) throws SQLException;

    public List<Member> findByDept(Long did) throws SQLException ;
}
