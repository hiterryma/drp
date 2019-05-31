package com.yootk.service.back.impl;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.*;
import com.yootk.service.back.IStorage_applyServiceBack;
import com.yootk.vo.*;

import java.util.*;

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
    @Autowired
    private ICityDAO cityDAO ;
    @Autowired
    private IStorage_apply_detailsDAO storage_apply_detailsDAO ;
    @Autowired
    private ISubmitdateDAO submitdateDAO ;

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
    public Map<String, Object> list(int outorin, String mid, Long currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        if (super.isEmpty(column,keyWord)) {
            //获取本页面的申请单信息
            List<Storage_apply> storage_applies = this.storage_applyDAO.findSplitByMember(outorin,mid,currentPage,lineSize) ;
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
            result.put("allRecorders",this.storage_applyDAO.getAllCountByMember(outorin,mid)) ;
            //保存仓库的地址
            result.put("warehouses",warehouses) ;
            //保存仓库的类型
            result.put("witems",witems) ;
        }else {//如果有查询列
            //获取本页面的申请单信息
            List<Storage_apply> storage_applies = this.storage_applyDAO.findSplitByMember(outorin,mid,currentPage,lineSize,column,keyWord) ;
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
            result.put("allRecorders",this.storage_applyDAO.getAllCountByMember(outorin,mid,column,keyWord)) ;
            //保存仓库的地址
            result.put("warehouses",warehouses) ;
            //保存仓库的类型
            result.put("witems",witems) ;
        }

        return result ;
    }

    @Override
    public boolean submit(Long said) throws Exception {
        Storage_apply storage_apply = this.storage_applyDAO.findById(said) ;
        storage_apply.setSubmit_status(1);
        Submitdate submitdate = new Submitdate() ;
        submitdate.setSaid(said);
        //设置当前时间为订单的提交时间
        submitdate.setSubmit_date(new Date());
        if (this.storage_applyDAO.doEdit(storage_apply) && this.submitdateDAO.doCreate(submitdate)){
            return true ;
        }
        return  false;
    }

    @Override
    public Map<String, Object> preEdit(Long said) throws Exception {
        Map<String,Object> result = new HashMap<>() ;
        Storage_apply storage_apply = this.storage_applyDAO.findById(said) ;
        //通过清单的cid编号查询具体的城市信息
        City city = this.cityDAO.findById(storage_apply.getCid()) ;
        //通过仓库编号wid查询出具体从仓库信息
        Warehouse warehouse = this.warehouseDAO.findById(storage_apply.getWid()) ;
        List<Province> allProvinces = this.provinceDAO.findAll() ;
        List<Witem> allWitems = this.witemDAO.findAll() ;
        result.put("allProvinces",allProvinces) ;
        result.put("allWitems",allWitems) ;
        result.put("storage_apply",storage_apply) ;
        result.put("city",city) ;
        result.put("warehouse",warehouse) ;
        return result ;
    }

    @Override
    public boolean edit(Storage_apply storage_apply) throws Exception {
        //为了避免数据为空的出现，先获取旧对象的数据
        Storage_apply oldSA = this.storage_applyDAO.findById(storage_apply.getSaid()) ;
        //在原来基础上进行修改
        oldSA.setTitle(storage_apply.getTitle());
        oldSA.setPid(storage_apply.getPid());
        oldSA.setCid(storage_apply.getCid());
        oldSA.setWiid(storage_apply.getWiid());
        oldSA.setWid(storage_apply.getWid());
        oldSA.setNote(storage_apply.getNote());
        return this.storage_applyDAO.doEdit(oldSA) ;
    }

    @Override
    public boolean delete(Set<Long> saids) throws Exception {
        return this.storage_applyDAO.doRemove(saids) ;
    }
    @Override
    public Map<String,Object> listByOutIn(int outorin, int smt, Long currentPage, Integer lineSize, String column, String keyWord) throws Exception{
        Map<String,Object> result = new HashMap<>() ;
        if (super.isEmpty(column,keyWord)) {
            //获取本页面的申请单信息
            List<Storage_apply> storage_applies = this.storage_applyDAO.findSplitByOutInAndSmt(outorin,smt,currentPage,lineSize) ;
            /**
             *  以下操作是错误的：因为在前端循环显示的时候，用的是storage_apply的list，而仓库地址storage_apply表的字段，
             *  //定义一个List集合，用于保存分页中的仓库信息，从而进行仓库地址的显示
             *             List<Warehouse> warehouses = new ArrayList<>() ;
             */
            //应该定义一个Map，key为wid,value为仓库地址。这样循环storage_apply的时候，就能根据每一个storage_apply的wid字段从map中查出来
            Map<Long,String> warehouses = new HashMap<>() ;
            //再定义个Map，保存仓库类型数据
            Map<Long,String> witems = new HashMap<>() ;
            //此Map存放每个订单的总数
            Map<Long,Integer> amounts = new HashMap<>() ;
            //此Map之中存放每个订单的总价
            Map<Long,Double> totalprices = new HashMap<>() ;
            //此Map存放订单提交日期数据
            Map<Long,Date> submitdatemap = new HashMap<>() ;


            //循环操作本页面的每一个申请单
            for (Storage_apply storage_apply : storage_applies) {
                //根据申请单之中所选的仓库的仓库编号查询出该仓库的所有数据
                Warehouse warehouse = this.warehouseDAO.findById(storage_apply.getWid()) ;
                //查询仓库类型
                Witem witem = this.witemDAO.findById(storage_apply.getWiid()) ;
                //仓库显示为：地址+仓库名称
                String title = warehouse.getAddress() + "   " + warehouse.getName() ;
                //查询订单提交数据
                Submitdate submitdate = this.submitdateDAO.findBySaid(storage_apply.getSaid()) ;
                warehouses.put(storage_apply.getWid(),title) ;
                witems.put(storage_apply.getWiid(),witem.getTitle()) ;
                submitdatemap.put(storage_apply.getSaid(),submitdate.getSubmit_date()) ;

                //查询出该订单的所有订单详情
                List<Storage_apply_details> allStorage_apply_details = this.storage_apply_detailsDAO.findAllBySaid(storage_apply.getSaid()) ;
                int amount = 0;
                double totalprice = 0.0 ;
                //计算每个清单里的商品总数和总价
                for (Storage_apply_details storage_apply_details : allStorage_apply_details) {
                    amount += storage_apply_details.getNum() ;
                    totalprice += storage_apply_details.getPrice() ;
                }
                amounts.put(storage_apply.getSaid(),amount) ;
                totalprices.put(storage_apply.getSaid(),totalprice) ;

            }
            //存放所有申请的List集合
            result.put("allStorage_applies",storage_applies) ;
            //存放所有的记录数
            result.put("allRecorders",this.storage_applyDAO.getAllCountByOutInAndSmtr(outorin,smt)) ;
            //保存仓库的地址
            result.put("warehouses",warehouses) ;
            //保存仓库的类型
            result.put("witems",witems) ;
            //保存商品总数
            result.put("amounts",amounts) ;
            //保存订单总价
            result.put("totalprices",totalprices) ;
            //保存提交日期
            result.put("submitdatemap",submitdatemap);
        }else {
            //获取本页面的申请单信息
            List<Storage_apply> storage_applies = this.storage_applyDAO.findSplitByOutInAndSmt(outorin,smt,currentPage,lineSize,column,keyWord) ;
            /**
             *  以下操作是错误的：因为在前端循环显示的时候，用的是storage_apply的list，而仓库地址storage_apply表的字段，
             *  //定义一个List集合，用于保存分页中的仓库信息，从而进行仓库地址的显示
             *             List<Warehouse> warehouses = new ArrayList<>() ;
             */
            //应该定义一个Map，key为wid,value为仓库地址。这样循环storage_apply的时候，就能根据每一个storage_apply的wid字段从map中查出来
            Map<Long,String> warehouses = new HashMap<>() ;
            //再定义个Map，保存仓库类型数据
            Map<Long,String> witems = new HashMap<>() ;
            //此Map存放每个订单的总数
            Map<Long,Integer> amounts = new HashMap<>() ;
            //此Map之中存放每个订单的总价
            Map<Long,Double> totalprices = new HashMap<>() ;
            //此Map存放订单提交日期数据
            Map<Long,Date> submitdatemap = new HashMap<>() ;


            //循环操作本页面的每一个申请单
            for (Storage_apply storage_apply : storage_applies) {
                //根据申请单之中所选的仓库的仓库编号查询出该仓库的所有数据
                Warehouse warehouse = this.warehouseDAO.findById(storage_apply.getWid()) ;
                //查询仓库类型
                Witem witem = this.witemDAO.findById(storage_apply.getWiid()) ;
                //查询订单提交数据
                Submitdate submitdate = this.submitdateDAO.findBySaid(storage_apply.getSaid()) ;
                //仓库显示为：地址+仓库名称
                String title = warehouse.getAddress() + "   " + warehouse.getName() ;
                warehouses.put(storage_apply.getWid(),title) ;
                witems.put(storage_apply.getWiid(),witem.getTitle()) ;
                submitdatemap.put(storage_apply.getSaid(),submitdate.getSubmit_date()) ;

                //查询出该订单的所有订单详情
                List<Storage_apply_details> allStorage_apply_details = this.storage_apply_detailsDAO.findAllBySaid(storage_apply.getSaid()) ;
                int amount = 0;
                double totalprice = 0.0 ;
                //计算每个清单里的商品总数和总价
                for (Storage_apply_details storage_apply_details : allStorage_apply_details) {
                    amount += storage_apply_details.getNum() ;
                    totalprice += storage_apply_details.getPrice() ;
                }
                amounts.put(storage_apply.getSaid(),amount) ;
                totalprices.put(storage_apply.getSaid(),totalprice) ;

            }
            //存放所有申请的List集合
            result.put("allStorage_applies",storage_applies) ;
            //存放所有的记录数
            result.put("allRecorders",this.storage_applyDAO.getAllCountByOutInAndSmtr(outorin,smt,column,keyWord)) ;
            //保存仓库的地址
            result.put("warehouses",warehouses) ;
            //保存仓库的类型
            result.put("witems",witems) ;
            //保存商品总数
            result.put("amounts",amounts) ;
            //保存订单总价
            result.put("totalprices",totalprices) ;
            //保存提交日期
            result.put("submitdatemap",submitdatemap);
        }
        return result ;
    }


}
