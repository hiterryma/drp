package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IStorage_applyServiceBack;
import com.yootk.vo.Storage_apply;

import java.util.Map;
@Controller
@RequestMapping("/pages/back/admin/storage/")
public class Storage_applyActionBack extends AbstractAction {
    @Autowired
    private IStorage_applyServiceBack storage_applyServiceBack ;

    /**
     * 申请单创建前的处理操作，主要返回的是省份、仓库类型的数据
     * @return
     */
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

    /**
     * 执行出入库清单创建
     * @param storage_apply
     * @return
     */
    @RequestMapping("storage_add")
    public ModuleAndView add(Storage_apply storage_apply) {

        //新创建的清单，设置审核状态为0：未审核
        storage_apply.setStatus(0);
        System.out.println(storage_apply);
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        //设置默认的提示信息
        String msg = "入库申请单创建失败！" ;
        String path = "/pages/back/admin/storage/storage_add_pre.action" ;
        try{
            //判断是否添加成功，如果成功改变提示信息
            if (this.storage_applyServiceBack.add(storage_apply)){
                msg = "入库申请单创建成功！" ;
            }
            mav.add("msg",msg);
            mav.add("path",path);
        }catch (Exception e){
            e.printStackTrace();
            mav.add("path",path);
        }
        return mav ;
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}