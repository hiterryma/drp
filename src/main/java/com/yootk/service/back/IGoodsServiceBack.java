package com.yootk.service.back;

import com.yootk.vo.Goods;

import java.util.List;
import java.util.Map;

public interface IGoodsServiceBack {
    /**
     * 查询入库人员和入库审核人员的详细信息，包括职位，所在的部门
     * @param mid 要查询人员的恶ID
     * @return 返回包含信息的集合
     * 4、key=voMember、value=被查询人员的详细信息
     * 1、key=level、value=被查询人员的职位
     * 1、key=dept、value=被查询人员所在的部门
     * @throws Exception
     */
    public Map<String ,Object> getMemberParticular(String mid)throws Exception;
    /**
     * 查询商品信息，以及商品对应的仓库信息
     * @param gid 要查询的商品ID
     * @return 返回Map集合
     * 1、key=goodsShow、value=商品的svo类
     * 1、key=goodsWid、value=仓库的vo类
     * 2、key=goodsProvince、value=仓库所在身份的信息
     * 3、key=goodsCity、value=仓库所在城市的信息
     * 4、key=voStorage、value=入库人员的信息
     * 5、key=voAudit、value=入库审核人员的信息
     * @throws Exception
     */
    public Map<String ,Object> getGidAndWid(Long gid) throws Exception;
    /**
     *   根据商品的ID查询该商品的详细信息
     * @param gid 商品ID
     * @return 返回商品的详细信息
     * @throws Exception
     */
    public Goods getById(Long gid)throws Exception;
    /**
     * 查询所有的二级子分类商品
     * @param stid
     * @return
     * @throws Exception
     */
    public List<Goods> getByStid(Long stid) throws Exception;

    public Goods get(Long gid) throws Exception ;
    public Map<String, Object> getByStid(Long stid,Long currentPage,Integer lineSize,String clonum,String keyword) throws Exception ;
}
