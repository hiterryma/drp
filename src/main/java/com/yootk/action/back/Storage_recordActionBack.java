package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.dao.IAuditDAO;
import com.yootk.service.back.IStorage_recordServiceBack;

import java.awt.event.MouseAdapter;
import java.util.Map;

@Controller
@RequestMapping("/pages/back/admin/manage/manage_storage/")
public class Storage_recordActionBack extends AbstractAction {
    @Autowired
    private IStorage_recordServiceBack storage_recordServiceBack ;

    @RequestMapping("search_pre")
    public ModuleAndView searchPre(Long said) {
        ModuleAndView mav = new ModuleAndView() ;
        try{
            Map<String,Object> map = this.storage_recordServiceBack.preSearch(said) ;
            if (map != null) {
                mav.setView("/pages/back/admin/manage/manage_storage.jsp");
                mav.add(map);
            }else {
                mav.setView("/pages/back/admin/manage/manage_storage_input.jsp"); ;
                mav.add("msg","该订单还未审核通过");

            }
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
