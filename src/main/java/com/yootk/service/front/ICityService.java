package com.yootk.service.front;

import com.yootk.vo.City;

import java.util.List;

public interface ICityService {
    public List<City> listByProvince(Long pid) throws Exception ;
}
