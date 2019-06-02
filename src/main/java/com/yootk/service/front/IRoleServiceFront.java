package com.yootk.service.front;

import com.yootk.vo.Member;

import java.util.Map;

public interface IRoleServiceFront {
    /**
     *
     * @param mid
     * @return
     * @throws Exception
     */
    public Member getByMid(String mid) throws Exception;
    /**
     * 查询雇员所在部门拥有的角色，以及角色对应的权限
     * @param mid 要查询的ID
     * @return 返回两个map集合
     * 1：key = allRoles、value = 拥有的角色信息集合
     * 2：key = allActions、value = 角色对应的权限信息
     * @throws Exception
     */
    public Map<String ,Object> role_action(String mid) throws Exception;
}
