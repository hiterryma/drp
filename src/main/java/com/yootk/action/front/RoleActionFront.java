package com.yootk.action.front;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.front.IRoleServiceFront;

@Controller
@RequestMapping("/pages/back/")
public class RoleActionFront extends AbstractAction {
    @Autowired
    private IRoleServiceFront roleServiceFront;

    @RequestMapping("member_message")
    public void member_message(){
        try {
            super.print(JSONObject.toJSONString(this.roleServiceFront.getByMid(super.getFrontUser())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("member_action")
    public ModuleAndView member_action() throws Exception {
        ModuleAndView mav = new ModuleAndView("/pages/back/index.jsp");
        mav.add(this.roleServiceFront.role_action(super.getFrontUser()));
        return mav;
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
