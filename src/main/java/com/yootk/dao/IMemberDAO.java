package com.yootk.dao;

import com.yootk.common.dao.IBaseDAO;
import com.yootk.vo.Member;

import java.sql.SQLException;
import java.util.List;

public interface IMemberDAO extends IBaseDAO<String , Member> {
    public Member findByIdAndpw(String mid) throws SQLException;
}
