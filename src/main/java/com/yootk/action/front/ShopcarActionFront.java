package com.yootk.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.service.front.IShopcarServiceFront;
import com.yootk.vo.Shopcar;

import java.util.*;

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
            System.out.println("***************************打印用户id：：：：*****"+super.getFrontUser());
            Map<String,Object> map=this.shopcarServiceFront.listByMember(super.getFrontUser());//Map<String, Object>， result.put("shopcar",shopcar) ;
            // result.put("allGoods",allGoods) ;
            mav.add(map); //直接将Map集合设置到request属性之中，${map.key("allGoods")}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    @RequestMapping("shopcar_edit")
    public void edit(String data){//data的机构为："gid:amount;gid:amount",这样可以传递一组也可以传递多组数据
        String results[]=data.split(";");//根据“;”拆分数据
        List<Shopcar> cars=new ArrayList<>();
        for(String result:results){
            String temp[]=result.split(":");
            Shopcar car=new Shopcar();
            car.setMid(super.getFrontUser());
            car.setGid(Long.parseLong(temp[0]));
            car.setAmount(Integer.parseInt(temp[1]));
            cars.add(car);
        }
        try {
            super.print(this.shopcarServiceFront.editBatch(cars));
        } catch (Exception e) {
            super.print(false);
        }
    }

    @RequestMapping("shopcar_delete")
    public void delete(String data){//在此方法中进行所有gid的获取，所有的gid的数据利用gids作为参数名称，格式为："gid;gid;gid;..."
        Set<Long> gids=new HashSet<>();
        String results[]=data.split(";");//根据“;”拆分数据
        for(String result:results){
            gids.add(Long.parseLong(result));//添加所有的商品编号
        }
        try{
            super.print(this.shopcarServiceFront.deleteByMember(super.getFrontUser(),gids));
        }catch (Exception e){
            super.print(false);
        }
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
