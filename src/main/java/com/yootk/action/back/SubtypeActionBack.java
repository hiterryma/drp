package com.yootk.action.back;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.back.ISubtypeService;
import com.yootk.vo.Subtype;

import java.util.List;

@Controller
@RequestMapping("/pages/back/admin/subtype/")
public class SubtypeActionBack extends AbstractAction {

    @Autowired
    private ISubtypeService subtypeService;

    @RequestMapping("list_subtype")
    public void listSubtype(Long wiid) {
        try {
            List<Subtype> list = this.subtypeService.findAllByWitem(wiid);
            //System.out.println(list);
            super.print(JSONObject.toJSONString(list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
