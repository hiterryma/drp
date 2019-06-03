package com.yootk.action.front;


import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.common.util.ResourceUtil;
import com.yootk.service.front.IPurchaseServiceFront;
import com.yootk.vo.Purchase;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pages/front/center/purchase/")
public class PurchaseActionFront extends AbstractAction {
    private static final String ACTION_TITLE = "客户";
    @Autowired
    private IPurchaseServiceFront purchaseServiceFront;

    @RequestMapping("city_list")
    public void city_list(Long pid){
        try {
            super.print(JSONObject.toJSONString(this.purchaseServiceFront.getCaty(pid)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     */
    @RequestMapping("purchase_authentication_list")
    public ModuleAndView purchase_authentication_list(){
        ModuleAndView mav = new ModuleAndView("/pages/front/center/purchase/purchase_authentication.jsp");
        try {
            mav.add("allProvince",this.purchaseServiceFront.getProvince());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    /**
     *
     * @return
     */
    @RequestMapping("purchase_add_list")
    public ModuleAndView purchase_add_list(){
        ModuleAndView mav = new ModuleAndView("/pages/front/center/purchase/purchase_add.jsp");
        try {
            mav.add("allProvince",this.purchaseServiceFront.getProvince());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    /**
     * 采购订单列表
     * @return
     */
    @RequestMapping("add_list")
    public ModuleAndView add_list(){
        ModuleAndView mav = new ModuleAndView("/pages/front/center/purchase/purchase_list.jsp");
        try {
            Map<String ,Object> map = this.purchaseServiceFront.getAllById(super.getFrontUser());
            ServletObject.getRequest().getSession().setAttribute("status",map.get("status"));
            if (map == null){
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("list.failure"));
            }else {
                mav.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("add_pre")
    public ModuleAndView add_pre(Purchase vo){
        ModuleAndView mav = new ModuleAndView(super.getPage("add.page"));
        vo.setMid(super.getFrontUser());
        vo.setSubdate(new Date());
        vo.setState(1);
        try {
            if (this.purchaseServiceFront.add(vo)) {
                mav.setView(super.getForwardPage());
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("add.page"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("add.success", ACTION_TITLE));
            } else {
                mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getPage("add.failure"));
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, ResourceUtil.getMessage("add.failure", ACTION_TITLE));
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
