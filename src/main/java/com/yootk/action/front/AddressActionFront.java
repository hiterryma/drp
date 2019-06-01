package com.yootk.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.Repository;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.front.IAddressServiceFront;
import com.yootk.vo.Address;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/pages/front/center/address/")  //定义路径，
public class AddressActionFront extends AbstractAction {
    public static final String ACTION_TITLE = "地址管理" ;
    @Autowired
    private IAddressServiceFront addressServiceFront ;

    //地址准备添加
    @RequestMapping("address_add_pre")   //路径合并
    public ModuleAndView addPre(Long[] pid) {
        ModuleAndView mav = new ModuleAndView("/pages/front/center/address/address_add.jsp");
        try {
            mav.add(this.addressServiceFront.preAdd());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  mav ;
    }
    //地址添加
    @RequestMapping("address_add")
    public ModuleAndView add(Address addresss) {
        addresss.setMid(super.getFrontUser()); // mid
        ModuleAndView mav = new ModuleAndView(super.getForwardPage());
        try {
            if (this.addressServiceFront.add(addresss)) {    // 进行数据保存
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, super.getMessge("vo.add.success", ACTION_TITLE));
            } else {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, super.getMessge("vo.add.failure", ACTION_TITLE));
            }
            super.getPage("list.page");
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
        } catch (Exception e) {
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
        }
        return mav;
    }

    //地址列表显示
    @RequestMapping("address_list")
    public ModuleAndView list() {
        ModuleAndView mav =new ModuleAndView(super.getPage("list.page"));
        try {
            mav.add(
                    this.addressServiceFront.list(super.getFrontUser()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return mav;
    }
    //地址删除
    @RequestMapping("address_delete")
    public void delete(String data) {
        System.out.println(data);
        Set<Long> adids = new HashSet<>() ;
        String results [] = data.split(";") ; // 根据“;”拆分数据
        for (String adid : results) {
            adids.add(Long.parseLong(adid)) ; // 添加所有的商品编号
        }
        try {
            super.print(this.addressServiceFront.deleteByAddress(super.getFrontUser(),adids));
        } catch (Exception e) {
            super.print(false);
        }
    }
    //地址修改准备
    @RequestMapping("address_edit_pre")   //路径合并
    public ModuleAndView editPre(Long[] pid) {
        ModuleAndView mav = new ModuleAndView("/pages/front/center/address/address_edit.jsp");
        try {
           mav.add(this.addressServiceFront.preEdit());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  mav ;
    }
//    地址修改
    @RequestMapping("address_edit")
    public ModuleAndView edit(Address addresss) {
        addresss.setMid(super.getFrontUser()); // mid
        ModuleAndView mav = new ModuleAndView(super.getForwardPage());
        try {
            if (this.addressServiceFront.edit(addresss)) {    // 进行数据保存
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, super.getMessge("vo.add.success", ACTION_TITLE));
            } else {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, super.getMessge("vo.add.failure", ACTION_TITLE));
            }
            super.getPage("list.page");
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
        } catch (Exception e) {
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
        }
        return mav;
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
