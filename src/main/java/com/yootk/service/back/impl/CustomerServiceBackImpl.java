package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.*;
import com.yootk.service.back.ICustomerServiceBack;
import com.yootk.vo.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerServiceBackImpl extends AbstractService implements ICustomerServiceBack {

    @Autowired
    private ICustomerDAO customerDAO;
    @Autowired
    private ICsourceDAO csourceDAO;
    @Autowired
    private ICitemDAO citemDAO;
    @Autowired
    private ICritemDAO critemDAO;
    @Autowired
    private IProvinceDAO provinceDAO;
    @Autowired
    private IMemberDAO memberDAO;
    @Autowired
    private ICustomerRecordDAO customerRecordDAO;

    @Override
    public Map<String, Object> preAdd() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("allProvinces", provinceDAO.findAll());
        map.put("allCsources", csourceDAO.findAll());
        map.put("allCitems", citemDAO.findAll());
        return map;
    }

    @Override
    public boolean add(Customer customer) throws Exception {
        customer.setIndate(new Date());
        customer.setStatus(1);
        customer.setType(1);
        return this.customerDAO.doCreate(customer);
    }

    @Override
    public boolean edit(Customer customer) throws Exception {
        return false;
    }

    @Override
    public boolean editForStatus(Integer status,String note,Long cuid) throws Exception {
        this.customerDAO.doEditForStatus(status,note,cuid) ;
        return false;
    }

    @Override
    public Map<String, Object> listByStatus(Long currentPage, Integer lineSize, String column, String keyword) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        if (column == null || "".equals(column) || keyword == null || "".equals(keyword)) {
            map.put("allCustomers", customerDAO.findSplitByStatus(currentPage, lineSize));
            map.put("allRecorders", customerDAO.getAllCountByStatus());
        }else {
            map.put("allCustomers", customerDAO.findSplitByStatus(currentPage, lineSize, column, keyword));
            map.put("allRecorders", customerDAO.getAllCountByStatus(column, keyword));
        }
        return map;
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Map<String, String> allMemberMap = new HashMap<>();
        Map<Long, String> allCitemMap = new HashMap<>();
        Map<Long, String> allCritemMap = new HashMap<>();

        List<Critem> critemList = this.critemDAO.findAll() ;
        for (Member member:memberDAO.findAll()) {
            allMemberMap.put(member.getMid(), member.getName());
        }
        map.put("allMemberMap", allMemberMap);
        for (Citem citem:citemDAO.findAll()) {
            allCitemMap.put(citem.getCiid(), citem.getTitle());
        }
        map.put("allCitemMap", allCitemMap);
        for(Critem critem :critemList){
            allCritemMap.put(critem.getCriid(),critem.getTitle());
        }
        map.put("allCritem",critemList) ;
        if (column == null || "".equals(column) || keyword == null || "".equals(keyword)) {
            map.put("allCustomers", customerDAO.findSplit(currentPage, lineSize));
            map.put("allRecorders", customerDAO.getAllCount());
        }else {
            map.put("allCustomers", customerDAO.findSplit(currentPage, lineSize, column, keyword));
            map.put("allRecorders", customerDAO.getAllCount(column, keyword));
        }
        return map;
    }

    @Override
    public boolean addForCustomerRecord(CustomerRecord customerRecord) throws Exception {
        return customerRecordDAO.doCreate(customerRecord) ;
    }

    @Override
    public Map<String, Object> listForCustomerRecord(Long currentPage, Integer lineSize, String column, String keyword) throws Exception {

        Map<String,Object> map = new HashMap<>() ;
        map.put("allCustomerRecord",customerRecordDAO.findSplit(currentPage,lineSize)) ;
        return map;
    }
}
