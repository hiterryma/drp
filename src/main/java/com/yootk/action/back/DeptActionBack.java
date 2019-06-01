package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.service.back.IDeptServiceBack;
import com.yootk.vo.Dept;

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
			mav.add(this.deptService.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
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
