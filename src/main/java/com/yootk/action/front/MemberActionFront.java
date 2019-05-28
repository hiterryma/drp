package com.yootk.action.front;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.encrypt.EncryptUtil;
import com.yootk.common.servlet.web.CookieUtil;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.common.util.ResourceUtil;
import com.yootk.service.front.IMemberServiceFront;
import com.yootk.vo.Member;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberActionFront extends AbstractAction {
    public static final String ACTION_TITLE = "用户";
    @Autowired
    private IMemberServiceFront memberService;

    @RequestMapping("/member_role")
    public void member_role(){
        try {
            super.print(JSONObject.toJSONString(this.memberService.access_right(super.getFrontUser())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/member_register")
    public ModuleAndView register(Member vo){
        ModuleAndView mav = new ModuleAndView(super.getPage("login.action"));
        vo.setPassword(EncryptUtil.encode(vo.getPassword()));
        try {
            if (memberService.register(vo)) {
                ServletObject.getRequest().getSession().setAttribute("mid", vo.getMid());
                mav.setView(super.getForwardPage());
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("login.success", ACTION_TITLE));
            } else {
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("index.page"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("login.failure", ACTION_TITLE));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    /**
     * 登录前的页面跳转处理
     *
     * @return 返回到登录页
     */
    @RequestMapping("/member_login_pre")
    public ModuleAndView loginPre() {
        ModuleAndView mav = new ModuleAndView(super.getPage("index.page"));
        return mav;
    }

    /**
     * 用户登录注销，登录注销后所有的Cookie信息将被删除
     *
     * @return 提示页面，随后跳转回登录页
     */
    @RequestMapping("/member_logout")
    public ModuleAndView logout() {
        ModuleAndView mav = new ModuleAndView(super.getForwardPage());
        CookieUtil.clean(ServletObject.getResponse(), "info");
        ServletObject.getRequest().getSession().invalidate();
        mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
        mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("logout.success", ACTION_TITLE));
        return mav;
    }

    /**
     * 验证码检测，用于ajax异步验证处理
     *
     * @param code 输入验证码
     */
    @RequestMapping("/code_check")
    public void check(String code) {
        String rand = (String) ServletObject.getRequest().getSession().getAttribute("rand");
        if (rand == null || "".equals(rand)) {
            super.print(false);
        } else {
            super.print(rand.equalsIgnoreCase(code));
        }
    }

    /**
     * 用户登录处理
     *
     * @param vo         包含有用户登录信息
     * @param rememberme 是否要执行免登录
     * @return 登录成功返回信息提示页（随后跳转到商品列表页），登录失败返回登录页
     */
    @RequestMapping("/member_login")
    public ModuleAndView login(Member vo, String rememberme) throws Exception {
        ModuleAndView mav = new ModuleAndView(super.getPage("login.action"));
        vo.setPassword(EncryptUtil.encode(vo.getPassword()));
        if (memberService.login(vo)) {
            ServletObject.getRequest().getSession().setAttribute("mid", vo.getMid());
            mav.setView(super.getForwardPage());
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("login.success", ACTION_TITLE));
            if (rememberme != null && "true".equals(rememberme)) {
                // 将用户信息保存在Cookie之中，方便用户下一次免登录操作
                CookieUtil.set("info", vo.getMid() + ":" + vo.getPassword(), ServletObject.getResponse());
            }
        } else {
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("index.page"));
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("login.failure", ACTION_TITLE));
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return "/upload/member";
    }
}
