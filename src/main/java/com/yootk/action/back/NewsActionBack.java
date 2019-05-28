package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.MultipartFile;
import com.yootk.common.servlet.web.PageUtil;
import com.yootk.common.servlet.web.ServletObject;
import com.yootk.service.back.INewsServiceBack;
import com.yootk.util.UploadFileToServer;
import com.yootk.vo.News;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pages/back/news/")
public class NewsActionBack extends AbstractAction {
	@Autowired
	private INewsServiceBack newsService;
	@RequestMapping("news_add")
	public ModuleAndView add(News news, MultipartFile file) {
		ModuleAndView mav = new ModuleAndView(super.getForwardPage()) ;
		try {
			String fileName = UploadFileToServer.upload(file,file.getContentType()) ;
			news.setPhoto(fileName);
			String msg = super.getMessge("vo.add.failure","公告") ;
			if (this.newsService.add(news)) {
				msg = super.getMessge("vo.add.success","公告") ;
			}
			String path = super.getPage("add.action") ;
			mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, path);
			mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav ;
	}
	/**
	 * 查看订单详情信息
	 * @return 订单详情显示
	 */
	@RequestMapping("news_show")
	public ModuleAndView show() {
		ModuleAndView mav = new ModuleAndView(super.getPage("show.page")) ;
		Long nid = Long.parseLong(ServletObject.getParameterUtil().getParameter("nid") );

		try{
		//	System.out.println(this.newsService.get(mid));
			Map<String,Object> map = new HashMap<>() ;
			map.put("news",this.newsService.get(nid)) ;
			mav.add(map);
		}catch (Exception e){
			e.printStackTrace();
		}
		return mav ;
	}

	@RequestMapping("news_list")
	public ModuleAndView list() {
		ModuleAndView mav = new ModuleAndView(super.getPage("list.page"));
		PageUtil pu = new PageUtil(super.getPage("list.action"),"标题:title");
		try {
			//mav.add(
			//		this.newsService.list(pu.getCurrentPage(), pu.getLineSize(),pu.getColumn(), pu.getKeyword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	@Override
	public String getUploadDir() {
		return "upload/news";
	}
}
