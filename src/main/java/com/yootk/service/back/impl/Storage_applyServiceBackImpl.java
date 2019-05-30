package com.yootk.service.back.impl;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.*;
import com.yootk.service.back.IStorage_applyServiceBack;
import com.yootk.vo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class Storage_applyServiceBackImpl extends AbstractService implements IStorage_applyServiceBack {
    @Autowired
    private IProvinceDAO provinceDAO;
    @Autowired
    private IWitemDAO witemDAO ;
    @Autowired
    private IStorage_applyDAO storage_applyDAO ;
    @Autowired
    private IWarehouseDAO warehouseDAO ;
    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        List<Province> allProvinces = this.provinceDAO.findAll() ;
        List<Witem> allWitems = this.witemDAO.findAll() ;
        result.put("allProvinces",allProvinces) ;
        result.put("allWitems",allWitems) ;
        return result ;
    }

    @Override
    public boolean add(Storage_apply storage_apply) throws Exception {
        return this.storage_applyDAO.doCreate(storage_apply) ;
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        if (super.isEmpty(column,keyWord)) {
            //获取本页面的申请单信息
            List<Storage_apply> storage_applies = this.storage_applyDAO.findSplit(currentPage,lineSize) ;
            /**
             *  以下操作是错误的：因为在前端循环显示的时候，用的是storage_apply的list，而仓库地址storage_apply表的字段，
             *  //定义一个List集合，用于保存分页中的仓库信息，从而进行仓库地址的显示
             *             List<Warehouse> warehouses = new ArrayList<>() ;
             */
            //应该定义一个Map，key为wid,value为仓库地址。这样循环storage_apply的时候，就能根据每一个storage_apply的wid字段从map中查出来
            Map<Long,String> warehouses = new HashMap<>() ;
            //再定义个Map，保存仓库类型数据
            Map<Long,String> witems = new HashMap<>() ;
            //循环操作本页面的每一个申请单
            for (Storage_apply storage_apply : storage_applies) {
                //根据申请单之中所选的仓库的仓库编号查询出该仓库的所有数据
                Warehouse warehouse = this.warehouseDAO.findById(storage_apply.getWid()) ;
                //查询仓库类型
                Witem witem = this.witemDAO.findById(storage_apply.getWiid()) ;
                //仓库显示为：地址+仓库名称
                String title = warehouse.getAddress() + "   " + warehouse.getName() ;
                warehouses.put(storage_apply.getWid(),title) ;
                witems.put(storage_apply.getWiid(),witem.getTitle()) ;
            }
            result.put("allStorage_applies",storage_applies) ;
            result.put("allRecorders",this.storage_applyDAO.getAllCount()) ;
            //保存仓库的地址
            result.put("warehouses",warehouses) ;
            //保存仓库的类型
            result.put("witems",witems) ;
        }else {//如果有查询列
            //获取本页面的申请单信息
            List<Storage_apply> storage_applies = this.storage_applyDAO.findSplit(currentPage,lineSize,column,keyWord) ;
            //应该定义一个Map，key为wid,value为仓库地址。这样循环storage_apply的时候，就能根据每一个storage_apply的wid字段从map中查出来
            Map<Long,String> warehouses = new HashMap<>() ;
            //再定义个Map，保存仓库类型数据
            Map<Long,String> witems = new HashMap<>() ;
            //循环操作本页面的每一个申请单
            for (Storage_apply storage_apply : storage_applies) {
                //根据申请单之中所选的仓库的仓库编号查询出该仓库的所有数据
                Warehouse warehouse = this.warehouseDAO.findById(storage_apply.getWid()) ;
                //查询仓库类型
                Witem witem = this.witemDAO.findById(storage_apply.getWiid()) ;
                //仓库显示为：地址+仓库名称
                String title = warehouse.getAddress() + "   " + warehouse.getName() ;
                warehouses.put(storage_apply.getWid(),title) ;

                witems.put(storage_apply.getWiid(),witem.getTitle()) ;
            }
            result.put("allStorage_applies",storage_applies) ;
            result.put("allRecorders",this.storage_applyDAO.getAllCount(column,keyWord)) ;
            //保存仓库的地址
            result.put("warehouses",warehouses) ;
            //保存仓库的类型
            result.put("witems",witems) ;
        }

        return result ;
    }
}
