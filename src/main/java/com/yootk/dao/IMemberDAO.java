package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Member;

import java.sql.SQLException;
import java.util.List;

public interface IMemberDAO extends IBaseDAO<String , Member> {
    /**
     * 查询用户ID和密码
     * @param mid  用户ID
     * @return 返回list（member）集合
     * @throws SQLException
     */
    public List<Member> findByIdAndPw(String mid) throws SQLException;
}
