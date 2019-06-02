package com.yootk.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.service.back.IWarehouseService;
import com.yootk.util.UploadFileToServer;
import com.yootk.vo.Warehouse;

@Controller
@RequestMapping("/pages/back/admin/warehouse/")
public class WarehouseActionBack extends AbstractAction {

    @Autowired
    private IWarehouseService warehouseService;

    @RequestMapping("warehouse_edit_admin")
    public void editAdmin(Long wid, String mid) throws Exception {
        super.print(JSONObject.toJSONString(this.warehouseService.editAdmin(wid, mid)));
    }

    @RequestMapping("warehouse_add")
    public ModuleAndView add(Warehouse warehouse, MultipartFile photo) throws Exception{
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
        String fileName = UploadFileToServer.upload(photo, photo.getContentType());
        warehouse.setPhoto(fileName);
        warehouse.setRecorder(super.getFrontUser());
        String msg = super.getMessge("vo.add.failure","仓库") ;
        if (this.warehouseService.add(warehouse)) {
            msg = super.getMessge("vo.add.success","仓库") ;
        }
        String path = super.getPage("add.action") ;
        mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
        mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        return mav ;

       /*// super.saveUploadFile(photo);
        String fileName = null;
        try {
            fileName = UploadFileToServer.upload(photo,photo.getContentType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        warehouse.setPhoto(fileName);
        warehouse.setRecorder(super.getFrontUser());
        try {
            warehouseService.add(warehouse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/back/admin/warehouse/warehouse_list.action";*/
    }

    @RequestMapping("warehouse_pre_add")
    public ModuleAndView preAdd() throws Exception{
        return new ModuleAndView(super.getPage("add.page"), this.warehouseService.preAdd());
    }

    @RequestMapping("warehouse_pre_edit")
    public ModuleAndView preEdit(Long wid) throws Exception{
        return new ModuleAndView(super.getPage("edit.page"), this.warehouseService.preEdit(wid));
//        try {
//            return new ModuleAndView("/pages/back/admin/warehouse/warehouse_edit.jsp", warehouseService.preEdit(wid));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @RequestMapping("warehouse_edit")
    public ModuleAndView edit(Warehouse warehouse,MultipartFile photo, String pic) throws Exception{
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;

        if (photo != null) {
            String fileName = UploadFileToServer.upload(photo, photo.getContentType());
            warehouse.setPhoto(fileName);
        }else {
            warehouse.setPhoto(pic);
        }
        warehouse.setRecorder(super.getFrontUser());
        String msg = super.getMessge("vo.edit.failure","仓库") ;
        if (this.warehouseService.edit(warehouse)) {
            msg = super.getMessge("vo.edit.success","仓库") ;
        }
        String path = super.getPage("edit.action") ;
        mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
        mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        return mav ;

//        String fileName = null;
//        try {
//            fileName = UploadFileToServer.upload(photo,photo.getContentType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        warehouse.setPhoto(fileName);
//        try {
//            warehouseService.edit(warehouse);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "/pages/back/admin/warehouse/warehouse_list.action";
    }

    @RequestMapping("warehouse_list")
    public ModuleAndView list() throws Exception{
        PageUtil pu = new PageUtil(super.getPage("list.action"), "仓库名称:name|仓库地址:address");
        return new ModuleAndView(super.getPage("list.page"),warehouseService.list(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
//        try {
//            return new ModuleAndView(super.getPage("list.page"),warehouseService.list(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
    }

    @Override
    public String getUploadDir() {
        return "/upload/back/warehouse/";
    }

    @RequestMapping("warehouse_list_wiid")
    public void listWarehouseByWiid(Long wiid){
        System.out.println(wiid);
        try {

            super.print(JSONObject.toJSONString(this.warehouseService.listWarehouseByWiid(wiid)));
            //System.out.println(this.warehouseService.listWarehouseByWiid(wiid));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("warehouse_list_pcw")
    public void listWarehouseByWiid(Long pid, Long cid, Long wiid){
        System.out.println(pid + "  " + cid + " "+ wiid);
        try {

            super.print(JSONObject.toJSONString(this.warehouseService.listWarehouseByPCW(pid,cid,wiid)));
            //System.out.println(this.warehouseService.listWarehouseByWiid(wiid));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
