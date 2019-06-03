package com.yootk.action.front;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.service.front.IRoleServiceFront;

import java.util.Map;

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
        Map<String ,Object> map = this.roleServiceFront.role_action(super.getFrontUser());
        ServletObject.getRequest().getSession().setAttribute("allRoles",map.get("allRoles"));
        ServletObject.getRequest().getSession().setAttribute("name",map.get("name"));
        ServletObject.getRequest().getSession().setAttribute("allActions",map.get("allActions"));
        ServletObject.getRequest().getSession().setAttribute("did",map.get("did"));
        mav.add(map);
        return mav;
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
