package com.yootk.service.back.impl;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.*;
import com.yootk.service.back.IGoodsServiceBack;
import com.yootk.vo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceBackImpl extends AbstractService implements IGoodsServiceBack {
    @Autowired
    private IGoodsDAO goodsDAO;
    @Autowired
    private IWarehouseDAO warehouseDAO;
    @Autowired
    private IProvinceDAO provinceDAO;
    @Autowired
    private ICityDAO cityDAO;
    @Autowired
    private IMemberDAO memberDAO;
    @Autowired
    private IStorage_applyDAO storage_applyDAO;
    @Autowired
    private ILevelDAO levelDAO;
    @Autowired
    private IDeptDAO deptDAO;

    @Override
    public Map<String, Object> getMemberParticular(String mid) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        Member voMember = this.memberDAO.findById(mid);
        //人员的职位
        Level level = this.levelDAO.findById(voMember.getLid());
        //人员所在的部门
        Dept dept = this.deptDAO.findById(voMember.getDid());
        map.put("voMember",voMember);
        map.put("level",level);
        map.put("dept",dept);
        return map;
    }

    @Override
    public Map<String, Object> getGidAndWid(Long gid) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        //商品信息
        Goods goods = this.goodsDAO.findById(gid);
        //商品所在的仓库信息
        Warehouse warehouse = this.warehouseDAO.findById(goods.getWid());
        //仓库所在的省份
        Province province = this.provinceDAO.findById(warehouse.getPid());
        //仓库所在的城市
        City city = this.cityDAO.findById(warehouse.getCid());
        //商品入库人员信息  默认是仓库管理员
        Member voStorage = this.memberDAO.findById(warehouse.getAdmin());
        //审核商品入库人员信息
        Storage_apply storage_apply = this.storage_applyDAO.findIdByMid(warehouse.getWid());
        Member voAudit = this.memberDAO.findById(storage_apply.getMid());

        map.put("goodsShow",goods);
        map.put("goodsWid",warehouse);
        map.put("goodsProvince",province);
        map.put("goodsCity",city);
        map.put("voStorage",voStorage);
        map.put("voAudit",voAudit);
        return map;
    }

    @Override
    public Goods getById(Long gid) throws Exception {
        return this.goodsDAO.findById(gid);
    }

    @Override
    public List<Goods> getByStid(Long stid) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> getByStid(Long stid,Long currentPage,Integer lineSize,String clonum,String keyword) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if (stid == null || "".equals(stid)){

        }else {
            if (super.isEmpty(clonum, keyword)) { // 不需要进行模糊查询
                map.put("allGoods", this.goodsDAO.findByStid(stid, currentPage, lineSize));
                map.put("allRecorders", this.goodsDAO.getAllCountByStid(stid));
            } else {
                map.put("allGoods", this.goodsDAO.findByStid(stid, currentPage, lineSize, clonum, keyword));
                map.put("allRecorders", this.goodsDAO.getAllCountByStid(stid, clonum, keyword));
            }
        }
        return map;
    }

    @Override
    public Goods get(Long gid) throws Exception {

        return this.goodsDAO.findById(gid) ;
    }

}
