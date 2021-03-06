package com.yootk.service.back;

import com.yootk.common.servlet.web.ModuleAndView;
import com.yootk.vo.Warehouse;

import java.util.List;
import java.util.Map;

public interface IWarehouseService {

    public boolean add(Warehouse warehouse) throws Exception;

    public Map<String, Object> preAdd() throws Exception;

    public Map<String, Object> preEdit(Long along) throws Exception;

    public boolean edit(Warehouse warehouse) throws Exception;

    public Map<String, Object> list(Long currentPage, Integer linesize, String column, String keyword) throws Exception;

    public boolean editAdmin(Long wid, String mid) throws Exception;

    public List<Warehouse> listWarehouseByWiid(Long wiid) throws Exception ;

    public List<Warehouse> listWarehouseByPCW(Long pid, Long cid, Long wiid) throws Exception ;

}
