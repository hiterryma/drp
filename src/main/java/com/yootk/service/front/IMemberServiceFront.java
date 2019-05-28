package com.yootk.service.front;

import com.yootk.vo.Member;

public interface IMemberServiceFront {
    /**
     * 在登录或者注册的时候查询用户的ID是否存在
     * @param mid  要检查的ID
     * @return 存在返回false，不存在返回true
     * @throws Exception
     */
    public boolean findById(String mid) throws Exception;
    /**
     * 访问权限（access_right）
     * 查询用户的did，判断是否有后台的访问权限
     * @param mid 要查询的用户ID
     * @return 返回did
     * @throws Exception
     */
    public Integer access_right (String mid) throws Exception;

    /**
     *
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean register(Member vo) throws Exception;

    /**
     * 实现登录验证
     * @param vo  需要验证的member集合
     * @return
     * @throws Exception
     */
    public boolean login(Member vo)throws Exception;
}
