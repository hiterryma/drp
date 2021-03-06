package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.*;
import com.yootk.service.back.IStorage_recordServiceBack;
import com.yootk.vo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class Storage_recordServiceBackImpl extends AbstractService implements IStorage_recordServiceBack {
    @Autowired
    private IAuditDAO auditDAO ;
    @Autowired
    private IStorage_applyDAO storage_applyDAO ;
    @Autowired
    private IWarehouseDAO warehouseDAO ;
    @Autowired
    private IWitemDAO witemDAO ;
    @Autowired
    private IStorage_apply_detailsDAO storage_apply_detailsDAO ;
    @Autowired
    private IGoodsDAO goodsDAO ;
    @Autowired
    private IStorage_recordDAO storage_recordDAO ;

    @Override
    public Map<String,Object> preSearch(Long said) throws Exception {
        //查询该清单的所有申请记录
        List<Audit> auditList = this.auditDAO.findAllBySaid(said) ;
        //System.out.println("---------" + auditList);
        Map<String,Object> result = new HashMap<>() ;
        if (auditList.size() != 0) {
            Long auditid = 0L ;
            for (Audit audit : auditList){
                if (auditid < audit.getAudid()){
                    auditid = audit.getAudid() ;
                }
            }
            Audit auditLast = this.auditDAO.findById(auditid) ;
            //如果该清单已审核通过
            if (auditLast.getAud_result() == 1){
                said = auditLast.getSaid() ;
                //保存单价的Map
                Map<Long,Double> pricemap = new HashMap<>() ;
                //保存重量的Map
                Map<Long,Double> weightmap = new HashMap<>() ;
                //根据清单编号查询该清单所有信息
                Storage_apply storage_apply = storage_applyDAO.findById(said) ;
                Long wid = storage_apply.getWid() ;
                Long wiid = storage_apply.getWiid() ;
                //找到清单对应的所有仓库数据
                Warehouse warehouse = warehouseDAO.findById(wid) ;

                //记录仓库地址+仓库名称
                String title = warehouse.getAddress() + "     " + warehouse.getName() ;
                //找到所有的仓库类型数据
                Witem witem = witemDAO.findById(wiid) ;

                List<Storage_apply_details> allStorage_apply_details = this.storage_apply_detailsDAO.findAllBySaid(said) ;
                for (Storage_apply_details storage_apply_details : allStorage_apply_details) {
                    Goods goods = this.goodsDAO.findById(storage_apply_details.getGid()) ;
                    pricemap.put(storage_apply_details.getSadid(),goods.getPrice()) ;
                    weightmap.put(storage_apply_details.getSadid(),goods.getWeight()) ;
                }
                result.put("storage_apply",storage_apply) ;
                result.put("title",title) ;
                result.put("witem",witem) ;
                result.put("pricemap",pricemap) ;
                result.put("weightmap",weightmap) ;
                //存放Storage_apply_details的List集合
                result.put("allStorage_apply_details",allStorage_apply_details) ;
                return result ;
            }


        }
        return null ;
    }

    @Override
    public boolean add(Storage_record storage_record) throws Exception {
        //从中取得清单编号
        Long said = storage_record.getSaid() ;
        //取得仓库id
        Long wid = this.storage_applyDAO.findById(said).getWid() ;
        //取得入库商品数量
        int num = storage_record.getNum() ;
        //取得仓库信息
        Warehouse warehouse = this.warehouseDAO.findById(wid) ;
        //取得仓库旧的数量
        int oldcurnum = warehouse.getCurrnum() ;
        //增加保存的商品数量
        warehouse.setCurrnum(oldcurnum+num);

        //取得商品id
        Long gid = storage_record.getGid() ;
        Goods goods = this.goodsDAO.findById(gid) ;

        //获得该商品以前的存储量
        int oldstornum = goods.getStornum() ;
        goods.setStornum(oldstornum+num);

        //修改仓库信息
        if (this.warehouseDAO.doEdit(warehouse) && this.goodsDAO.doEdit(goods)) {
            return this.storage_recordDAO.doCreate(storage_record) ;
        }
        return false;
    }

}
