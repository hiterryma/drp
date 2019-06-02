package com.yootk.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.service.back.IDeptServiceBack;
import com.yootk.vo.Dept;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pages/back/admin/dept/")
public class DeptActionBack extends AbstractAction {
	@Autowired
	private IDeptServiceBack deptService;

	@RequestMapping("dept_list")
	public ModuleAndView list() {
		ModuleAndView mav = new ModuleAndView(super.getPage("list.page"));
		PageUtil pu = new PageUtil(super.getPage("list.action"));
		try {
			mav.add(this.deptService.list(pu.getCurrentPage(),10,pu.getColumn(), pu.getKeyword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("dept_list_all")
    public void listAll() throws Exception{
        super.print(JSONObject.toJSONString(this.deptService.list()));
    }

    @RequestMapping("dept_member_list")
	public void listDeptMember(Long did, Long currentPage, Integer lineSize)throws Exception {
//		PageUtil pu = new PageUtil(super.getPage("/pages/back/admin/dept/dept_member_list.action"), null);
//		System.out.println(pu);
//		Long cp = pu.getCurrentPage();
//		Integer ls = pu.getLineSize();
//		System.out.println(cp);
//		System.out.println(ls);
		Map<String, Object> map = this.deptService.ListMemberbyDept(did, currentPage, lineSize);
		super.print(JSONObject.toJSONString(map));
	}

	@RequestMapping("dept_edit")
	public void edit(Long did,String dname) {
		try {
			Dept dept = new Dept() ;
			dept.setDid(did);
			dept.setDname(dname);
			if (this.deptService.edit(dept)){
				super.print(true);
			}else {
				super.print(false);
			}
		} catch (Exception e) {
			super.print(false);
			e.printStackTrace();
		}
	}

	@Override
	public String getUploadDir() {
		return "upload/news";
	}
}
