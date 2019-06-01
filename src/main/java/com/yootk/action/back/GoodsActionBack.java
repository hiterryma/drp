package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.*;
import com.yootk.service.back.IGoodsService;
import com.yootk.util.UploadFileToServer;
import com.yootk.vo.Goods;
import com.yootk.service.back.IGoodsServiceBack;

import java.util.Map;

@Controller
@RequestMapping("/pages/back/admin/goods/")
public class GoodsActionBack extends AbstractAction {

    @Autowired
    private IGoodsService goodsService;
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

    @RequestMapping("goods_pre_add")
    public ModuleAndView preAdd() throws Exception{
        return new ModuleAndView(super.getPage("add.page"), this.goodsService.preAdd());
//        try {
//            return new ModuleAndView("/pages/back/admin/goods/goods_add.jsp", goodsService.preAdd());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @RequestMapping("goods_pre_edit")
    public ModuleAndView preEdit(Long gid) throws Exception{
        return new ModuleAndView(super.getPage("edit.page"), this.goodsService.preEdit(gid));
//        try {
//            return new ModuleAndView("/pages/back/admin/goods/goods_edit.jsp",this.goodsService.preEdit(gid));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @RequestMapping("goods_add")
    public ModuleAndView add(Goods goods, MultipartFile photo) throws Exception{
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
        String fileName = UploadFileToServer.upload(photo, photo.getContentType());
        goods.setPhoto(fileName);
        goods.setRecorder(super.getFrontUser());
        String msg = super.getMessge("vo.add.failure","商品") ;
        if (this.goodsService.add(goods)) {
            msg = super.getMessge("vo.add.success","商品") ;
        }
        String path = super.getPage("add.action") ;
        mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
        mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        return mav ;
//        try {
//            String fileName = UploadFileToServer.upload(photo,photo.getContentType());
//            goods.setPhoto(fileName);
//            goods.setRecorder(super.getFrontUser());
//            this.goodsService.add(goods);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "/pages/back/admin/goods/goods_list.action";
    }

    @RequestMapping("goods_edit")
    public ModuleAndView edit(Goods goods, MultipartFile photo, String pic) throws Exception{
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;

        if (photo != null) {
            String fileName = UploadFileToServer.upload(photo, photo.getContentType());
            goods.setPhoto(fileName);
        }else {
            goods.setPhoto(pic);
        }
        goods.setRecorder(super.getFrontUser());
        String msg = super.getMessge("vo.edit.failure","商品") ;
        if (this.goodsService.edit(goods)) {
            msg = super.getMessge("vo.edit.success","商品") ;
        }
        String path = super.getPage("edit.action") ;
        mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
        mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        return mav ;
//        try {
//            String fileName = UploadFileToServer.upload(photo,photo.getContentType());
//            goods.setPhoto(fileName);
//            goods.setRecorder(super.getFrontUser());
//            this.goodsService.edit(goods);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "/pages/back/admin/goods/goods_list.action";
    }

    @RequestMapping("goods_list")
    public ModuleAndView list() throws Exception{
        PageUtil pu = new PageUtil(super.getPage("list.action"), "商品名称:name|商品编号:gid");
        return new ModuleAndView(super.getPage("list.page"),goodsService.list(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
//        PageUtil pu = new PageUtil("/pages/back/admin/goods/goods_list.action", "商品名称:name|商品编号:gid");
//        try {
//            return new ModuleAndView("/pages/back/admin/goods/goods_list.jsp",this.goodsService.list(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @RequestMapping("goods_subaru")
    public ModuleAndView goods_subaru(Long stid) {
        ModuleAndView mav = new ModuleAndView("/pages/front/goods/goods_list.jsp");
        PageUtil pu = new PageUtil("/pages/back/admin/goods/goods_subaru.action","商品名称:name");
        try {
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, "/pages/back/admin/goods/goods_subaru.action");
            mav.add(this.goodsServiceBack.getByStid(stid,pu.getCurrentPage(),pu.getLineSize(),pu.getColumn(),pu.getKeyword()));
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
