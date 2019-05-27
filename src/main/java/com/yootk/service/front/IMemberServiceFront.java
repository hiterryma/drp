package com.yootk.service.front;

import com.yootk.vo.Member;

public interface IMemberServiceFront {
    public boolean register(Member vo) throws Exception;

    /**
     * 实现登录验证
     * @param vo  需要验证的member集合
     * @return
     * @throws Exception
     */
    public boolean login(Member vo)throws Exception;
}
