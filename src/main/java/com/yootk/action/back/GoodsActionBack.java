package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.dao.IGoodsDAO;
import com.yootk.service.back.IGoodsService;
import com.yootk.util.UploadFileToServer;
import com.yootk.vo.Goods;

@Controller
@RequestMapping("/pages/back/admin/goods/")
public class GoodsActionBack extends AbstractAction {

    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("goods_pre_add")
    public ModuleAndView preAdd() {
        try {
            return new ModuleAndView("/pages/back/admin/goods/goods_add.jsp", goodsService.preAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("goods_pre_edit")
    public ModuleAndView preEdit(Long gid) {
        System.out.println("**************" + gid);
        try {
            return new ModuleAndView("/pages/back/admin/goods/goods_edit.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("goods_add")
    public String add(Goods goods, MultipartFile photo) {
        try {
            String fileName = UploadFileToServer.upload(photo,photo.getContentType());
            goods.setPhoto(fileName);
            goods.setRecorder(super.getFrontUser());
            this.goodsService.add(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/back/admin/goods/goods_list.jsp";
    }

    @RequestMapping("goods_list")
    public ModuleAndView list() {
        return new ModuleAndView("/pages/back/admin/goods/goods_list.jsp");
    }

    @Override
    public String getUploadDir() {
        return "/upload/back/goods";
    }
}
