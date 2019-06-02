package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.service.back.IStorage_applyServiceBack;
import com.yootk.vo.Storage_apply;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        //设置出入库标记
        storage_apply.setOutorin(1);
        //设置用户编号
        storage_apply.setMid(super.getBackUser());
        //设置提交状态未提交
        storage_apply.setSubmit_status(0);
        //新创建的清单，设置审核状态为0：未审核
        storage_apply.setAudit_status(0);

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
    @RequestMapping("storage_list")
    public ModuleAndView list() {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_list_myself.jsp") ;
        /**
         * 实例化分页组件
         * 1、第一个参数是分页显示的页面
         * 2、第二个参数是当进行分页查询的时候的查询关键字，比如（商品名称:name)
         * 3、如果不需要查询的时候第二个参数的内容可以为空
         */
        PageUtil pu = new PageUtil("/pages/back/admin/storage/storage_list_myself.jsp", "入库单编号:said|入库申请标题:title");
        try {
            mav.add(this.storage_applyServiceBack.list(1,super.getBackUser(),pu.getCurrentPage(),pu.getLineSize(),pu.getColumn(),pu.getKeyword()));
            System.out.println(pu.getColumn());
            System.out.println(pu.getKeyword());
        }catch (Exception e){
            e.printStackTrace();
        }
        return mav ;
    }
    @RequestMapping("storage_submit")
    public ModuleAndView submit(Long said) {
        System.out.println(said);
        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        //设置默认的提示信息
        String msg = "入库申请单提交失败！" ;
        String path = "/pages/back/admin/storage/storage_list.action" ;
        try{
            //判断是否提交成功，如果成功改变提示信息
            if (this.storage_applyServiceBack.submit(said)){
                msg = "入库申请单提交成功！" ;
            }
            mav.add("msg",msg);
            mav.add("path",path);
        }catch (Exception e){
            e.printStackTrace();
            mav.add("path",path);
        }
        return mav ;

    }

    @RequestMapping("storage_edit_pre")
    public ModuleAndView editPre(Long said) {
        System.out.println(said);
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storage/storage_edit.jsp") ;
        try {
            mav.add(this.storage_applyServiceBack.preEdit(said));

            System.out.println(mav);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mav ;
    }
    @RequestMapping("storage_edit")
    public ModuleAndView edit(Storage_apply storage_apply) {
        System.out.println(storage_apply);

        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        //设置默认的提示信息
        String msg = "入库申请单修改失败！" ;
        String path = "/pages/back/admin/storage/storage_list.action" ;
        try{
            //判断是否提交成功，如果成功改变提示信息
            if (this.storage_applyServiceBack.edit(storage_apply)){
                msg = "入库申请单修改成功！" ;
            }
            mav.add("msg",msg);
            mav.add("path",path);
        }catch (Exception e){
            e.printStackTrace();
            mav.add("path",path);
        }
        return mav ;
    }
    @RequestMapping("storage_delete")
    public ModuleAndView delete(Long said) {
        System.out.println(said);

        ModuleAndView mav = new ModuleAndView("/pages/plugins/forward.jsp") ;
        //设置默认的提示信息
        String msg = "入库申请单删除失败！" ;
        String path = "/pages/back/admin/storage/storage_list.action" ;
        Set<Long> saids = new HashSet<>() ;
        saids.add(said) ;
        try{
            //判断是否提交成功，如果成功改变提示信息
            if (this.storage_applyServiceBack.delete(saids)){
                msg = "入库申请单删除成功！" ;
            }
            mav.add("msg",msg);
            mav.add("path",path);
        }catch (Exception e){
            e.printStackTrace();
            mav.add("path",path);
        }
        return mav ;
    }

    @RequestMapping("storage_list_In")
    public ModuleAndView listByIn() {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storageaudit/storageaudit_list_prepare.jsp");
        /**
         * 实例化分页组件
         * 1、第一个参数是分页显示的页面
         * 2、第二个参数是当进行分页查询的时候的查询关键字，比如（商品名称:name)
         * 3、如果不需要查询的时候第二个参数的内容可以为空
         */
        PageUtil pu = new PageUtil("/pages/back/admin/storageaudit/storageaudit_list_prepare.jsp", "入库单编号:said|入库申请标题:title");
        try {
            mav.add(this.storage_applyServiceBack.listByOutIn(1,1,0, pu.getCurrentPage(),pu.getLineSize(),pu.getColumn(),pu.getKeyword()));
            System.out.println(pu.getColumn());
            System.out.println(pu.getKeyword());
        }catch (Exception e){
            e.printStackTrace();
        }
        return mav ;
    }

    @RequestMapping("storage_list_In_aud_history")
    public ModuleAndView listByInAudhistory() {
        ModuleAndView mav = new ModuleAndView("/pages/back/admin/storageaudit/storageaudit_list_history.jsp");
        /**
         * 实例化分页组件
         * 1、第一个参数是分页显示的页面
         * 2、第二个参数是当进行分页查询的时候的查询关键字，比如（商品名称:name)
         * 3、如果不需要查询的时候第二个参数的内容可以为空
         */
        PageUtil pu = new PageUtil("/pages/back/admin/storageaudit/storageaudit_list_history.jsp", "入库单编号:said|入库申请标题:title");
        try {
            mav.add(this.storage_applyServiceBack.listByOutIn(1,1,1, pu.getCurrentPage(),pu.getLineSize(),pu.getColumn(),pu.getKeyword()));
            System.out.println(pu.getColumn());
            System.out.println(pu.getKeyword());
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
