package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IStorage_applyServiceBack;

import java.util.Map;
@Controller
@RequestMapping("/pages/back/admin/storage/")
public class Storage_applyActionBack extends AbstractAction {
    @Autowired
    private IStorage_applyServiceBack storage_applyServiceBack ;
    @RequestMapping("storage_add_pre")
    public ModuleAndView addPre() {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_add.jsp") ;
        try {
            mav.add(this.storage_applyServiceBack.preAdd());
            System.out.println(mav);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;

    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
