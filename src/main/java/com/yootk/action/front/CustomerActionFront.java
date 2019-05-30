package com.yootk.action.front;


import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.util.ResourceUtil;
import com.yootk.service.front.ICustomerServiceFront;
import com.yootk.vo.Customer;

import java.util.Date;

@Controller
@RequestMapping("/pages/front/center/purchase/")
public class CustomerActionFront extends AbstractAction {
    public static final String ACTION_TITLE = "客户";
    @Autowired
    private ICustomerServiceFront customerServiceFront;

    @RequestMapping("add_pre")
    public ModuleAndView add_pre(Customer vo) {
        vo.setMid(super.getFrontUser());  //设置当前登录用户的ID
        vo.setCiid(0L); //客户等级编号
        vo.setCsid(0L);  //客户来源编号
        vo.setConnum(0); //客户的联系次数
        vo.setIndate(new Date()); //客户的录入日期，为当前日期
        vo.setStatus(0);   //前台用户，默认设置为未认证
        ModuleAndView mav = new ModuleAndView(super.getPage("password.page"));
        try {
            if (this.customerServiceFront.add(vo)) {
                mav.setView(super.getForwardPage());
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("password.page"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("password.success", ACTION_TITLE));
            } else {
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("password.page"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("password.failure", ACTION_TITLE));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
