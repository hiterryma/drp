package com.yootk.action.back;

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

    @RequestMapping("warehouse_add")
    public String add(Warehouse warehouse, MultipartFile photo) {
       // super.saveUploadFile(photo);
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
        return "/pages/back/admin/warehouse/warehouse_list.action";
    }

    @RequestMapping("warehouse_pre_add")
    public ModuleAndView preAdd() {
        try {
            return new ModuleAndView("/pages/back/admin/warehouse/warehouse_add.jsp",warehouseService.preAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("warehouse_pre_edit")
    public ModuleAndView preEdit(Long wid) {
        try {
            return new ModuleAndView("/pages/back/admin/warehouse/warehouse_edit.jsp", warehouseService.preEdit(wid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("warehouse_edit")
    public String edit(Warehouse warehouse,MultipartFile photo) {
        String fileName = null;
        try {
            fileName = UploadFileToServer.upload(photo,photo.getContentType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        warehouse.setPhoto(fileName);
        try {
            warehouseService.edit(warehouse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/back/admin/warehouse/warehouse_list.action";
    }

    @RequestMapping("warehouse_list")
    public ModuleAndView list() {
        PageUtil pu = new PageUtil("/pages/back/admin/warehouse/warehouse_list.action", "仓库名称:name|仓库地址:address");
        try {
            return new ModuleAndView("/pages/back/admin/warehouse/warehouse_list.jsp",warehouseService.list(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getUploadDir() {
        return "/upload/back/warehouse/";
    }
}
