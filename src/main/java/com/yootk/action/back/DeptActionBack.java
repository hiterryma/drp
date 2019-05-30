package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IDeptService;
@Controller
@RequestMapping("/pages/back/admin/dept/")
public class DeptActionBack extends AbstractAction {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("dept_list")
    public ModuleAndView list() {
        try {
            return new ModuleAndView("/pages/plugins/back/modal/member_dept_list_modal.jsp", deptService.listDeptMember());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getUploadDir() {
        return "/upload/back/dept";
    }
}
