package com.yootk.service.back;

import com.yootk.vo.Member;

import java.util.Map;
import java.util.Set;

public interface IMemberServiceBack {

    /**
     * 用来添加新的雇员
     * @param member 雇员实例对象
     * @return 返回true表示添加成功，false表示添加失败
     * @throws Exception
     */
    public boolean add(Member member) throws Exception ;
    /**
     * 用来修改雇员信息
     * @param member 雇员实例对象
     * @return 返回true表示添加成功，false表示添加失败
     * @throws Exception
     */
    public boolean edit(Member member) throws Exception ;

    /**
     * 用来获取雇员列表信息
     * @param currentPage 当前页数
     * @param lineSize   每页显示数量
     * @param column    查询列
     * @param keyword   查询内容
     * @return
     * key =allMembers  表示返回的列表集合
     * @throws Exception
     */
    public Map<String,Object> list(Long currentPage,Integer lineSize,String column,String keyword) throws Exception ;

    /**
     * 获取用户表实例
     * @param mid 用户唯一ID
     * @return 返回用户实例对象
     * @throws Exception
     */
    public Member get(String mid ) throws Exception ;

    /**
     * 批量删除数据
     * @param mids 用户ID删除，其为字符串数组
     * @return
     * @throws Exception
     */
    public boolean delete(Set<String> mids) throws Exception ;

    /**
     * 员工修改页面打开时需加装数据封装
     * @param mid 要修改的用户ID
     * @return
     * key member ,存储内容为雇员的相关信息
     * key dept  ,存储部门map对象
     * key levle ,存储职位map对象
     * @throws Exception
     */
    public Map<String,Object> preEdit(String mid) throws Exception ;
    public Map<String,Object> preAdd() throws Exception ;
}
