package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IStorage_apply_detailsServiceBack;
import com.yootk.vo.Storage_apply_details;

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

    @RequestMapping("storage_details_addoredit")
    public void addOrEdit(Long sadid, Long said, Long gid, String name, int num, Double price, Double weight) {
        System.out.println("*******+++++++++");
        System.out.println(sadid+ "++++"+said+ "++++"+gid+ "++++"+name+ "++++"+num+ "++++"+price+ "++++"+weight);

        Storage_apply_details storage_apply_details = new Storage_apply_details() ;
        storage_apply_details.setSaid(said);
        storage_apply_details.setName(name);
        storage_apply_details.setSadid(sadid);
        storage_apply_details.setGid(gid);
        storage_apply_details.setNum(num) ;
        storage_apply_details.setPrice(price);
        storage_apply_details.setWeight(weight);
        System.out.println(storage_apply_details);
        try {
            //1、使用的是Ajax实现，所以要用print()函数
            super.print(this.storage_apply_detailsServiceBack.addOrEdit(storage_apply_details));
        } catch (Exception e) {
            super.print(false);
        }

    }
}
