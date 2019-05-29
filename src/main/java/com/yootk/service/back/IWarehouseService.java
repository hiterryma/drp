package com.yootk.service.back;

import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.vo.Warehouse;

import java.util.Map;

public interface IWarehouseService {

    public boolean add(Warehouse warehouse) throws Exception;

    public Map<String, Object> preAdd() throws Exception;

    public Map<String, Object> preEdit(Long along) throws Exception;

    public boolean edit(Warehouse warehouse) throws Exception;

    public Map<String, Object> list(Long currentPage, Integer linesize, String column, String keyword) throws Exception;

}
