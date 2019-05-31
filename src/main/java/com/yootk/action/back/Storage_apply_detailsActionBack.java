package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IStorage_apply_detailsServiceBack;

import java.awt.event.MouseAdapter;
@Controller
@RequestMapping("/pages/back/admin/storage_details/")
public class Storage_apply_detailsActionBack extends AbstractAction {
    @Autowired
    private IStorage_apply_detailsServiceBack storage_apply_detailsServiceBack ;

    @Override
    public String getUploadDir() {
        return null;
    }

    /**
     * 入库申请详情创建之前的处理
     * 根据指定的入库申请单编号，查询出相关数据
     * @param said
     * @return
     */
    @RequestMapping("storage_details_add_pre")
    public ModuleAndView addPre(Long said) {
        System.out.println(said);
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_list_details.jsp") ;
        try {
            mav.add(this.storage_apply_detailsServiceBack.preAdd(said));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }
}
