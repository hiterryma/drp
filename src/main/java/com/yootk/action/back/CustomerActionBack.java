package com.yootk.action.back;

import com.alibaba.fastjson.JSONObject;
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
import com.yootk.vo.CustomerRecord;
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
        customer.setRecorder(super.getBackUser());
        customer.setMid(super.getBackUser());
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
        return new ModuleAndView(super.getPage("audit_list.page"), customerServiceBack.listByStatus(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
    }

    @RequestMapping("customer_list")
    public ModuleAndView list() throws Exception {
        PageUtil pu = new PageUtil(super.getPage("list.action"), "客户姓名:name|联系电话:phone|联系地址:address");
        return new ModuleAndView(super.getPage("list.page"),customerServiceBack.list(pu.getCurrentPage(), pu.getLineSize(), pu.getColumn(), pu.getKeyword()));
    }
    //客户审核
    @RequestMapping("customer_audit")
    public void audit(Integer audit,String note,Long cuid) throws Exception{
        if (this.customerServiceBack.editForStatus(audit,note,cuid)) {
            super.print(false);
        }else {
            super.print(true);
        }
    }
    @RequestMapping("customerrecord_pre_add")
    public void customerRecordInputInfo() throws Exception{

        super.print(JSONObject.toJSON(customerServiceBack.preAddCustomerRecord()));
    }
    //客户沟通记录获取
    @RequestMapping("customer_record_list")
    public void customerRecordList(Long currentPage,Integer lineSize,String cuid) throws Exception{
        PageUtil pu = new PageUtil(super.getPage("audit_list.action"));
        super.print(JSONObject.toJSON(customerServiceBack.listForCustomerRecord(currentPage, lineSize, "cuid",cuid)));
    }
    //添加客户沟通记录
    @RequestMapping("customer_record_add")
    public void audit(String title,String note,Long criid,Long cuid) throws Exception{
        CustomerRecord customerRecord = new CustomerRecord() ;
        customerRecord.setCmid(super.getFrontUser());
        customerRecord.setCuid(cuid);
        customerRecord.setNote(note);
        customerRecord.setCriid(criid);
        customerRecord.setTitle(title);
       if (this.customerServiceBack.addForCustomerRecord(customerRecord)) {
            super.print(true);
        }else {
            super.print(false);
        }
    }
    @Override
    public String getUploadDir() {
        return "/upload/back/customer";
    }
}
