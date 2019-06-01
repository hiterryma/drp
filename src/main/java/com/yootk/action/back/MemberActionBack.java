package com.yootk.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.service.back.IMemberServiceBack;
import com.yootk.service.back.INewsServiceBack;
import com.yootk.util.UploadFileToServer;
import com.yootk.vo.Member;
import com.yootk.vo.News;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/pages/back/admin/member/")
public class MemberActionBack extends AbstractAction {
	@Autowired
	private IMemberServiceBack memberServiceBack;

	@RequestMapping("member_pre_add")
	public ModuleAndView preAdd(String mid) {
		ModuleAndView mav = new ModuleAndView(super.getPage("add.page")) ;
		try{
			mav.add(this.memberServiceBack.preAdd());
		}catch (Exception e){
			e.printStackTrace();
		}
		return mav ;
	}

	@RequestMapping("member_add")
	public ModuleAndView add(Member member, MultipartFile pic) {
		ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
		try {
			String fileName = UploadFileToServer.upload(pic,pic.getContentType()) ;
			member.setPhoto(fileName);
			String msg = super.getMessge("vo.add.failure","雇员") ;
			System.out.println(member);
			if (this.memberServiceBack.add(member)) {
				msg = super.getMessge("vo.add.success","雇员") ;
			}
			String path = super.getPage("add.action") ;
			mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
			mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav ;
	}

	@RequestMapping("member_list")
	public ModuleAndView list() {
		ModuleAndView mav = new ModuleAndView(super.getPage("list.page"));
		PageUtil pu = new PageUtil(super.getPage("list.action"),"用户:name");
		try {
			//System.out.println(this.memberServiceBack.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));
			mav.add(this.memberServiceBack.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping("member_pre_edit")
	public ModuleAndView preEdit(String mid) {
		ModuleAndView mav = new ModuleAndView(super.getPage("edit.page")) ;
		try{
			//System.out.println(this.memberServiceBack.preEdit(mid));
			mav.add(this.memberServiceBack.preEdit(mid));
		}catch (Exception e){
			e.printStackTrace();
		}
		return mav ;
	}
	@RequestMapping("member_edit")
	public ModuleAndView edit(Member member, MultipartFile pic) {
		ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
		try {
			String fileName = "" ;
			if (pic != null){
				fileName  = UploadFileToServer.upload(pic,pic.getContentType()) ;
			}
			member.setPhoto(fileName);
			String msg = super.getMessge("vo.edit.failure","雇员") ;
			if (this.memberServiceBack.edit(member)) {
				msg = super.getMessge("vo.edit.success","雇员") ;
			}
			String path = super.getPage("list.action") ;
			mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
			mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav ;
	}
	@RequestMapping("member_delete")
	public void delete(String data) {
		Set<String> ids = new HashSet<>() ;
		String results [] = data.split(";") ; // 根据“;”拆分数据
		for (String str : results) {
            ids.add(str) ; // 添加所有的商品编号
		}
		try {
			super.print(this.memberServiceBack.delete(ids));
		} catch (Exception e) {
			super.print(false);
		}
	}
	/**
	 * 进行用户的个人资料查询
	 */
	@RequestMapping("memberJson")
	public void memberJson(String mid){
		try {
			super.print(JSONObject.toJSON(this.memberServiceBack.preEdit(mid)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("member_info")
    public void memberInfo(String mid) throws Exception{
	    super.print(JSONObject.toJSONString(this.memberServiceBack.getMemberInfo(mid)));
    }

	@Override
	public String getUploadDir() {
		return "upload/member";
	}
}
