package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.IShopcarDAO;
import com.yootk.service.front.IShopcarServiceFront;
import com.yootk.vo.Shopcar;
@Service //注解业务层
public class ShopcarServiceFrontImpl extends AbstractService implements IShopcarServiceFront {
    @Autowired //自动注入
    private IShopcarDAO shopcarDAO;
    @Override
    public boolean add(Shopcar vo) throws Exception {
        //1.根据用户id和商品编号查询已有的购物车中的保存的商品数量
        Integer amout=this.shopcarDAO.findAmountByMemberAndGoods(vo.getMid(),vo.getGid());
        if(amout==null){    //此时还没有相应的购物数据的存储
            vo.setAmount(1);//假设现在追加一次
            return this.shopcarDAO.doCreate(vo);//2.保存一条新的记录
        }else{
            //3.如果此时的amount已经存在
            amout++;
            return this.shopcarDAO.doEditAmountByMemberAndGoods(vo.getMid(),vo.getGid(),amout);
        }

    }
}
