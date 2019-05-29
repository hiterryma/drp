package com.yootk.action.front;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.service.back.INewsServiceBack;
import com.yootk.service.front.INewsServiceFront;
import com.yootk.util.UploadFileToServer;
import com.yootk.vo.News;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/pages/front/news/")
public class NewsActionFront extends AbstractAction {
	@Autowired
	private INewsServiceFront newsService;
	@RequestMapping("news_list")
	public ModuleAndView front_show() {
		ModuleAndView mav = new ModuleAndView(super.getPage("list.page")) ;
		PageUtil pu = new PageUtil(super.getPage("list.action"));
		try {
			mav.add(this.newsService.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav ;
	}
	@RequestMapping("news_index")
	public void news_indexpage() {
		try {
			super.print(JSONObject.toJSONString(this.newsService.getListForIndex()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public String getUploadDir() {
		return "upload/news";
	}
}
