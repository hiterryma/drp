package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IDistributionServiceBack;

@Controller
@RequestMapping("/pages/back/admin/distribution/")
public class DistributionActionBack extends AbstractAction {
    @Autowired
    IDistributionServiceBack distributionServiceBack ;
    @RequestMapping("distribution_add_pre")
    public ModuleAndView addpre(){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/distribution/distribution_goods_list.jsp") ;
        try {
            mav.add(this.distributionServiceBack.preAdd(super.getBackUser()));
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
