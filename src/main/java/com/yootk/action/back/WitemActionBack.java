package com.yootk.action.back;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.IWitemServiceBack;
import com.yootk.vo.Subtype;
import com.yootk.vo.Witem;

import java.util.List;

@Controller
public class WitemActionBack extends AbstractAction {

    @Autowired
    private IWitemServiceBack witemServiceBack;

    /**
     * 进行商品分类查询
     * @return
     */
    @RequestMapping("/classify")
    public ModuleAndView classify(){
        ModuleAndView mav = new ModuleAndView("mall_index.jsp");
        try {
            mav.add(this.witemServiceBack.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
