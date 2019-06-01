package com.yootk.action.front;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.service.front.ICityService;

@Controller
@RequestMapping("/pages/front/city/")
public class CityActionFront extends AbstractAction {
    @Autowired
    private ICityService cityService ;
    @RequestMapping("city_list")
    public void listCity(Long pid) {
        try {
            super.print(JSONObject.toJSONString(this.cityService.listByProvince(pid)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getUploadDir() {
        return null;
    }
}
