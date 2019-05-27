package com.yootk.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.front.IShopcarServiceFront;
import com.yootk.vo.Shopcar;

import java.util.Map;

@Controller
@RequestMapping("/pages/front/center/shopcar/")
public class ShopcarActionFront extends AbstractAction {
    @Autowired
    private IShopcarServiceFront shopcarServiceFront;
    @RequestMapping("shopcar_add")
    public void add(Shopcar vo){    //一般增加的时候需要有一个商品编号就够了
        if(super.getFrontUser()==null){//如果用户没有登录
            super.print(false);   //添加失败
        }else{
            vo.setMid(super.getFrontUser()); //设置当前的用户名
            try {
                this.shopcarServiceFront.add(vo);
            } catch (Exception e) {
                super.print(false);
            }
        }

    }
    @RequestMapping("shopcar_list")
    public ModuleAndView list(){
        ModuleAndView mav=new ModuleAndView(super.getPage("list.page"));
        try {
            Map<String,Object> map=this.shopcarServiceFront.listByMember(super.getFrontUser());
            mav.add(map); //直接将Map集合设置到request属性之中
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
