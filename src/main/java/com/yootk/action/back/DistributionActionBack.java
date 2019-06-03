package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IDistributionServiceBack;
import com.yootk.vo.Distribution;

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

    @RequestMapping("distribution_showpc")
    public  ModuleAndView showPC(Long cuid) {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/distribution/distribution_add.jsp") ;
        try {
            mav.add(this.distributionServiceBack.showPC(cuid));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

    @RequestMapping("distribution_add")
    public ModuleAndView add(Distribution distribution) {
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        //设置默认的提示信息
        String msg = "出库申请创建成功" ;
        String path = "/pages/back/admin/distribution/distribution_list_myself.jsp" ;
        try {

        }catch (Exception e){
            e.printStackTrace();
        }
        return mav ;
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
