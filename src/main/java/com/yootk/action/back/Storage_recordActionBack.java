package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.dao.IAuditDAO;
import com.yootk.service.back.IStorage_recordServiceBack;
import com.yootk.vo.Storage_record;

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

    @RequestMapping("storage_record_add")
    public void add(Long said, Long gid, String name, int num, Double price, Double weight, int status) {
        Storage_record storage_record = new Storage_record() ;
        storage_record.setSaid(said);
        storage_record.setGid(gid);
        storage_record.setName(name);
        storage_record.setNum(num);
        storage_record.setPrice(price);
        storage_record.setWeight(weight);
        storage_record.setStatus(status);
        storage_record.setInmid(super.getBackUser());

        try {
            //1、使用的是Ajax实现，所以要用print()函数
            super.print(this.storage_recordServiceBack.add(storage_record));
        } catch (Exception e) {
            super.print(false);
        }

    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
