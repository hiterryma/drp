package com.yootk.action;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ServletObject;

@Controller
public class CodeAction extends AbstractAction {
    /**
     * 验证码检测，用于ajax异步验证处理
     *
     * @param code 输入验证码
     */
    @RequestMapping("/code_check")
    public void check(String code) {
        System.out.println("---");
        String rand = (String) ServletObject.getRequest().getSession().getAttribute("rand");
        if (rand == null || "".equals(rand)) {
            super.print(false);
        } else {
            super.print(rand.equalsIgnoreCase(code));
        }
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
