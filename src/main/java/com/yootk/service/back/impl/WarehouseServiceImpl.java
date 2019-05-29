package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.dao.abs.AbstractDAO;
import com.yootk.dao.*;
import com.yootk.service.back.IWarehouseService;
import com.yootk.vo.Member;
import com.yootk.vo.Warehouse;
import com.yootk.vo.Witem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarehouseServiceImpl extends AbstractDAO implements IWarehouseService {
    @Autowired
    private IWarehouseDAO warehouseDAO;
    @Autowired
    private IProvinceDAO provinceDAO;
    @Autowired
    private ICityDAO cityDAO;
    @Autowired
    private IWitemDAO witemDAO;
    @Autowired
    private IMemberDAO memberDAO;

    @Override
    public boolean add(Warehouse warehouse) throws Exception {
        warehouse.setCurrnum(0);
        return warehouseDAO.doCreate(warehouse);
    }

    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("allWitems", witemDAO.findAll());
        map.put("allProvinces", provinceDAO.findAll());
        return map;
    }

    @Override
    public Map<String, Object> preEdit(Long along) throws Exception {
        Warehouse warehouse = warehouseDAO.findById(along);
        Map<String, Object> map = new HashMap<>();
        map.put("allWitems", witemDAO.findAll());
        map.put("allProvinces", provinceDAO.findAll());
        map.put("warehouse", warehouse);
        map.put("allCitys", cityDAO.findAllByProvince(warehouse.getPid()));
        return map;
    }

    @Override
    public boolean edit(Warehouse warehouse) throws Exception {
        return warehouseDAO.doEdit(warehouse);
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer linesize, String column, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Map<String, String> allMemberMap = new HashMap<>();
        Map<Long, String> allWitemMap = new HashMap<>();
        for (Member member:memberDAO.findAll()) {
            allMemberMap.put(member.getMid(), member.getName());
        }
        for (Witem witem:witemDAO.findAll()) {
            allWitemMap.put(witem.getWiid(), witem.getTitle());
        }
        map.put("allMemberMap", allMemberMap);
        map.put("allWitemMap", allWitemMap);
        if (column == null || "".equals(column) || keyword == null ||"".equals(keyword)) {
            map.put("allRecorders", warehouseDAO.getAllCount());
            map.put("allWarehouses", warehouseDAO.findSplit(currentPage, linesize));
        }else {
            map.put("allRecorders", warehouseDAO.getAllCount(column, keyword));
            map.put("allWarehouses", warehouseDAO.findSplit(currentPage, linesize, column, keyword));
        }
        return map;
    }

}
