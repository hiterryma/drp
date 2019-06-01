package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IAuditServiceBack;
import com.yootk.vo.Audit;

import java.util.Date;

@Controller
@RequestMapping("/pages/back/admin/audit/")
public class AuditActionBack extends AbstractAction {
    @Autowired
    private IAuditServiceBack auditServiceBack ;

    @RequestMapping("audit_add_pre")
    public ModuleAndView addPre(Long said){
        System.out.println(said);
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storageaudit/storageaudit_edit.jsp") ;
        try {
            mav.add(this.auditServiceBack.preAdd(said));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }

    @RequestMapping("audit_add")
    public ModuleAndView add(Long said, int audit_result, String audit_note){
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_list_In.action") ;
        Audit audit = new Audit() ;
        audit.setSaid(said);
        audit.setAud_member(super.getBackUser());
        audit.setAud_result(audit_result);
        audit.setAud_note(audit_note);
        audit.setAud_date(new Date());
        //设置默认的提示信息
        String msg = "处理审核失败！" ;
        String path = "/pages/back/admin/audit/audit_add_pre.action" ;
        try{
            //判断是否添加成功，如果成功改变提示信息
            if (this.auditServiceBack.audit(said,audit)){
                msg = "处理审核成功！" ;
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
