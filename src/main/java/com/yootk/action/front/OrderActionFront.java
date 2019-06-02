package com.yootk.action.front;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;
import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.common.servlet.web.PageUtil;

import com.yootk.service.front.IOrderServiceFront;
import java.util.*;
import static com.yootk.action.front.MemberActionFront.ACTION_TITLE;
@Controller
@RequestMapping("/pages/front/center/orders/")
public class OrderActionFront extends AbstractAction {
    @Autowired
    private IOrderServiceFront orderServiceFront;
    /**
     * 实现订单创建处理
     * @return 订单创建页面
     */
    @RequestMapping("orders_add")
    public ModuleAndView add(String gid,String aid,String note) throws Exception {//add( String gid,String aid)
        Set<Long> gidSet = new HashSet<>();
        String gids[]=gid.split(", ");
        for(int x=0;x<gids.length;x++){
            Long gidd=Long.parseLong(gids[x]);
            gidSet.add(gidd);
        }
        ModuleAndView mav = new ModuleAndView("/pages/front/center/orders/orders_list.action");  //super.getForwardPage()
        try {
            if (this.orderServiceFront.add(aid,gidSet,note)) {    // 进行数据保存
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, super.getMessge("vo.add.success", ACTION_TITLE));
            } else {
                mav.add(AbstractAction.MSG_ATTRIBUTE_NAME, super.getMessge("vo.add.failure", ACTION_TITLE));
            }
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
        } catch (Exception e) {
            mav.add(AbstractAction.PATH_ATTRIBUTE_NAME, super.getIndexPage());
            e.printStackTrace();
        }

        return mav;
    }
    /**
     * 查看订单详情信息
     *
     * @return 订单详情显示
     */
    @RequestMapping("orders_details_show")
    public ModuleAndView show(Long oid ) throws Exception {
        ModuleAndView mav = new ModuleAndView(super.getPage("show.page"));
        try {
            mav.add(this.orderServiceFront.getDetails(oid));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    /**
     * 实现订单创建前的处理
     * @return  订单创建页面
     */
    @RequestMapping("orders_add_pre")
    public ModuleAndView addPre(Long[] gid){
        Set<Long> gidSet=new HashSet<>();
        gidSet.addAll(Arrays.asList(gid)); // 将数组通过List添加到Set之中
        ModuleAndView mav=new ModuleAndView(super.getPage("add.page"));

        try {

            Map<String,Object> map = new HashMap<>() ;
            String strGid = Arrays.asList(gid).toString() ;
            strGid = strGid.substring(1,strGid.length()-1);

            map.put("AllAddress",orderServiceFront.findAllAdress());
            map.put("gid",strGid);
            mav.add(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }
    /**
     * 实现订单信息列表显示
     *
     * @return 跳转到订单列表页
     */
    @RequestMapping("orders_list")
    public ModuleAndView list() {
        ModuleAndView mav = new ModuleAndView(super.getPage("list.page"));
        PageUtil pu = new PageUtil(super.getPage("list.action"), null);
        try {
            mav.add(
                    this.orderServiceFront.list(super.getFrontUser(), pu.getCurrentPage(), pu.getLineSize()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @Override
    public String getUploadDir() {
        return "/upload/orders";
    }
}
