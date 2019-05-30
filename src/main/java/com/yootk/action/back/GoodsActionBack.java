package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.*;
import com.yootk.service.back.IGoodsService;
import com.yootk.service.back.IGoodsServiceBack;

@Controller
@RequestMapping("/pages/back/admin/goods/")
public class GoodsActionBack extends AbstractAction {

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private IGoodsServiceBack goodsServiceBack;

    @RequestMapping("goods_subaru")
    public ModuleAndView goods_subaru(Long stid) {
        ModuleAndView mav = new ModuleAndView("/pages/front/goods/goods_list.jsp");
        PageUtil pu = new PageUtil("/pages/back/admin/goods/goods_subaru.action","商品名称:name");
        try {
            System.out.println(stid+"、"+pu.getCurrentPage()+"、"+ pu.getLineSize()+"、"+ pu.getColumn()+"、"+  pu.getKeyword());
            mav.add(this.goodsServiceBack.getByStid(stid,pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));
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
