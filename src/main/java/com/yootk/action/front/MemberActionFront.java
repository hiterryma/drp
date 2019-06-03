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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class MemberActionFront extends AbstractAction {
    public static final String ACTION_TITLE = "用户";
    @Autowired
    private IMemberServiceFront memberService;
    @RequestMapping("/update_password")
    public ModuleAndView update_password(String oldpassword,String newpassword){
        ModuleAndView mav = new ModuleAndView(super.getPage("edit.page"));
        try {
            if (this.memberService.update_password(oldpassword,newpassword,super.getFrontUser())){
                mav.setView(super.getForwardPage());
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("password.page"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("password.success", ACTION_TITLE));
            }else {
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("password.page"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("password.failure", ACTION_TITLE));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    /**
     * 进行用户资料修改
     * @param vo  包含要修改的资料
     * @return
     */
    @RequestMapping("/updeate_member")
    public ModuleAndView updeate_member(Member vo){
        ModuleAndView mav = new ModuleAndView(super.getPage("edit.page"));
        vo.setMid(super.getFrontUser());
        try {
            if (memberService.update_personalData(vo)) {
                mav.setView(super.getForwardPage());
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("edit.page"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("edit.success", ACTION_TITLE));
            } else {
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("edit.page"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("edit.failure", ACTION_TITLE));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    /**
     * 进行用户的个人资料查询
     */
    @RequestMapping("/member_datum")
    public void member_datum(){
        try {
            super.print(JSONObject.toJSONString(this.memberService.findBy_personalData(super.getFrontUser())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户注册时对用户ID是否存在进行检测，用于ajax异步验证处理
     */
    @RequestMapping("/checkMid")
    public void checkMid(String id){
        try {
            if (this.memberService.findById(id)){  //如果返回的flase，表示用户ID以存在
                super.print(false);
            }else {
                super.print(true);  // 表示用户ID不存在，可以注册
            }
        } catch (Exception e) {
            super.print(true);
            e.printStackTrace();
        }
    }

    /**
     * 对登录用户是否为后台用户进行检测，用于ajax异步验证处理
     */
    @RequestMapping("/member_role")
    public void member_role(){
        try {
            super.print(JSONObject.toJSONString(this.memberService.access_right(super.getFrontUser())));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
     * 实现前台用户注册
     * @param id 需要注册的ID
     * @param password 密码
     * @param name 名称
     * @return
     */
    @RequestMapping("/member_register")
    public ModuleAndView register(String id,String name,String password){
        ModuleAndView mav = new ModuleAndView(super.getIndexPage());
        Member vo = new Member();
        vo.setMid(id);
        vo.setName(name);
        vo.setPassword(EncryptUtil.encode(password));
        try {
            if (memberService.add_register(vo)) {
                mav.setView(super.getForwardPage());
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("regist.success", ACTION_TITLE));
            } else {
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("regist.page"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("regist.failure", ACTION_TITLE));
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
        ModuleAndView mav = new ModuleAndView(super.getPage("login.page"));
        return mav;
    }

    @RequestMapping("/member_login_filter")
    public ModuleAndView loginFilter() {
        ModuleAndView mav = new ModuleAndView(super.getPage("index.page"));
        mav.setView(super.getForwardPage());
        mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("member.login", ACTION_TITLE));
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
        vo.setLasttime(new Date());
        Map<String,Object> result = memberService.login(vo);
        boolean flag = (boolean)result.get("flag") ;
        if (flag) {
            ServletObject.getRequest().getSession().setAttribute("mid", vo.getMid());
            mav.setView(super.getForwardPage());
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("login.success", ACTION_TITLE));
            if (rememberme != null && "true".equals(rememberme)) {
                // 将用户信息保存在Cookie之中，方便用户下一次免登录操作
                CookieUtil.set("info", vo.getMid() + ":" + vo.getPassword(), ServletObject.getResponse());
            }
        } else {
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("login.page"));
            mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("login.failure", ACTION_TITLE));
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return "/upload/member";
    }
}
