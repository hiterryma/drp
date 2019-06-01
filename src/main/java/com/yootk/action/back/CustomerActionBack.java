package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.Repository;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.service.back.ICustomerServiceBack;
import com.yootk.util.UploadFileToServer;
import com.yootk.vo.Customer;
import com.yootk.vo.Goods;

@Controller
@RequestMapping("/pages/back/admin/customer/")
public class CustomerActionBack extends AbstractAction {

    @Autowired
    private ICustomerServiceBack customerServiceBack;

    @RequestMapping("customer_pre_add")
    public ModuleAndView preAdd() throws Exception{
        return new ModuleAndView(super.getPage("add.page"), this.customerServiceBack.preAdd());
    }

    @RequestMapping("customer_add")
    public ModuleAndView add(Customer customer) throws Exception{
        ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
        String msg = super.getMessge("vo.add.failure","客户") ;
        customer.setRecorder(super.getFrontUser());
        customer.setMid(super.getFrontUser());
        if (this.customerServiceBack.add(customer)) {
            msg = super.getMessge("vo.add.success","客户") ;
        }
        String path = super.getPage("add.action") ;
        mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
        mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
        return mav ;
    }

    @RequestMapping("customer_audit_list")
    public ModuleAndView listByStatus() throws Exception {
        PageUtil pu = new PageUtil(super.getPage("audit_list.action"), "客户姓名:name|联系电话:phone|联系地址:address");
        return new ModuleAndView(super.getPage("audit_list.page"),customerServiceBack.listByStatus(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
    }

    @RequestMapping("customer_list")
    public ModuleAndView list() throws Exception {
        PageUtil pu = new PageUtil(super.getPage("list.action"), "客户姓名:name|联系电话:phone|联系地址:address");
        return new ModuleAndView(super.getPage("list.page"),customerServiceBack.list(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
    }

    @Override
    public String getUploadDir() {
        return "/upload/back/customer";
    }
}
