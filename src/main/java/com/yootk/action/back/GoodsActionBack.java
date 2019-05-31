package com.yootk.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.*;
import com.yootk.service.back.IGoodsService;
import com.yootk.service.back.IGoodsServiceBack;

import java.util.Map;

@Controller
@RequestMapping("/pages/back/admin/goods/")
public class GoodsActionBack extends AbstractAction {

    @Autowired
    private IGoodsServiceBack goodsServiceBack;

    @RequestMapping("getGoods")
    public ModuleAndView getGoods(Long gid){
        ModuleAndView mav = new ModuleAndView("/pages/front/goods/goods_show.jsp");
        try {
            mav.add("getGoods",this.goodsServiceBack.getById(gid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("goods_subaru11")
    public void goods_subaru11(Long stid) {
        ServletObject.getRequest().getSession().removeAttribute("stid");
        ServletObject.getRequest().getSession().setAttribute("stid",stid);
    }

    @RequestMapping("goods_subaru")
    public ModuleAndView goods_subaru(Long stid) {
        //Long stid = (Long) ServletObject.getRequest().getSession().getAttribute("stid");
        ServletObject.getRequest().removeAttribute("stid");
        PageUtil pu = new PageUtil("/pages/back/admin/goods/goods_subaru.action","商品名称:name");
        ModuleAndView mav = new ModuleAndView("/pages/front/goods/goods_list.jsp");
        try {
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/goods/goods_subaru.action");
            mav.add(this.goodsServiceBack.getByStid(stid,pu.getCurrentPage(),pu.getLineSize(),pu.getColumn(),pu.getKeyword()));
            //mav.add(this.goodsServiceBack.getByStid(stid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return "/upload/back/goods";
    }
}
