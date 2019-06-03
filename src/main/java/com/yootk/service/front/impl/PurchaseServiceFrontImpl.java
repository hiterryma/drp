package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.ICityDAO;
import com.yootk.dao.ICustomerDAO;
import com.yootk.dao.IProvinceDAO;
import com.yootk.dao.IPurchaseDAO;
import com.yootk.service.front.IPurchaseServiceFront;
import com.yootk.vo.City;
import com.yootk.vo.Province;
import com.yootk.vo.Purchase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseServiceFrontImpl extends AbstractService implements IPurchaseServiceFront {
    @Autowired
    private IPurchaseDAO purchaseDAO;
    @Autowired
    private IProvinceDAO provinceDAO;
    @Autowired
    private ICityDAO cityDAO;
    @Autowired
    private ICustomerDAO customerDAO;
    @Override
    public List<City> getCaty(Long pid) throws Exception {
        return this.cityDAO.findAllByProvince(pid);
    }

    @Override
    public List<Province> getProvince() throws Exception {
        return this.provinceDAO.findAll();
    }

    @Override
    public Map<String,Object> getAllById(String mid) throws Exception {
        Map<String ,Object> map = new HashMap<>();
        List<Purchase> all = this.purchaseDAO.findAllById(mid);
        if (all == null){
            map.put(null,null);
        }else {
            map.put("allPurchase",all);
            map.put("status",this.customerDAO.findByMid(mid));
        }
        return map;
    }

    @Override
    public boolean add(Purchase vo) throws Exception {
        return this.purchaseDAO.doCreate(vo);
    }
}
