package com.yootk.service.back;

import com.yootk.vo.Distribution_member_goods_details;

public interface IDistribution_member_goods_detailsServiceBack  {
    /**
     * 进行商品修改或增加
     * @param distribution_member_goods_details
     * @return
     * @throws Exception
     */
    public boolean addOrEdit(Distribution_member_goods_details distribution_member_goods_details) throws Exception ;
}
