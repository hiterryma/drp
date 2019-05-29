package com.yootk.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IGoodsServiceBack;

@Controller
@RequestMapping("/pages/front/goods/")
public class GoodsActionBack extends AbstractAction {
    @Autowired
    private IGoodsServiceBack goodsServiceBack;

    @RequestMapping("goods_subaru")
    public ModuleAndView goods_subaru(Long stid) {
        ModuleAndView mav = new ModuleAndView("/pages/front/goods/goods_list.jsp");
        try {
            mav.add("allLists",this.goodsServiceBack.getByStid(stid));
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
