package com.yootk.service.front;

import com.yootk.vo.Member;

import java.util.Map;

public interface IMemberServiceFront {

    /**
     *
     * @param oldpassword
     * @param newpassword
     * @param mid
     * @return
     * @throws Exception
     */
    public boolean update_password(String oldpassword,String newpassword,String mid) throws Exception;
    /**
     * 进行用户资料的修改
     * @param vo  包含需要修改的资料
     * @return 成功返回true，否则返回false
     * @throws Exception
     */
    public boolean update_personalData(Member vo) throws Exception;
    /**
     * 查询前台雇员的个人资料（personalData）
     * @param mid 要查询的ID
     * @return 返回全部的个人信息
     * @throws Exception
     */
    public Member findBy_personalData(String mid)throws Exception;
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
    public boolean add_register(Member vo) throws Exception;

    /**
     * 实现登录验证
     * @param vo  需要验证的member集合
     * @return
     * @throws Exception
     */
    public boolean login(Member vo)throws Exception;
}
