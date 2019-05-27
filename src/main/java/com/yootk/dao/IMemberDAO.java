package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Member;

import java.sql.SQLException;
import java.util.List;

public interface IMemberDAO extends IBaseDAO<String , Member> {
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
}
