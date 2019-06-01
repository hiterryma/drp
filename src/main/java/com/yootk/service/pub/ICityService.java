package com.yootk.service.pub;

import com.yootk.common.service.abs.AbstractService;
import com.yootk.vo.City;

import java.util.List;

public interface ICityService {

    public List<City> listByProvince(Long pid) throws Exception;

}
