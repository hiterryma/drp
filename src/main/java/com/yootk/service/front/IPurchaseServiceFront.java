package com.yootk.service.front;

import com.yootk.vo.City;
import com.yootk.vo.Province;
import com.yootk.vo.Purchase;

import java.util.List;
import java.util.Map;

public interface IPurchaseServiceFront {
    /**
     * 根据所有的省份ID，查询该省份下的所有城市
     * @param pid  省份ID
     * @return 返回包含城市信息的集合
     * @throws Exception
     */
    public List<City> getCaty(Long pid) throws Exception;
    /**
     * 查询所有的城市信息
     * @return
     * @throws Exception
     */
    public List<Province> getProvince()throws Exception;
    /**
     * 查询采购申请单详细信息
     * @return 返回map集合包含
     * key=allpurchase、value=所有采购单的List集合
     * @throws Exception
     */
    public Map<String,Object>  getAllById(String mid) throws Exception;
    /**
     * 大宗采购申请单填写
     * @param vo 申请单内容
     * @return 成功返回true，否则返回false
     * @throws Exception
     */
    public boolean add(Purchase vo)throws Exception;
}
