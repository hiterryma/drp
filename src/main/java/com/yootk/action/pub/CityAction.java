package com.yootk.action.pub;

import com.alibaba.fastjson.JSONObject;
import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.service.pub.ICityService;

@Controller
@RequestMapping("/pages/pub/city/")
public class CityAction extends AbstractAction {

    @Autowired
    private ICityService cityService;
    @RequestMapping("list_city")
    public void listCity(Long pid) {
        try {
            super.print(JSONObject.toJSONString(this.cityService.listByProvince(pid)));
            //System.out.println(this.cityService.listByProvince(pid));
            System.out.println(pid);
            System.out.println("************");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getUploadDir() {
        return null;
    }


}
