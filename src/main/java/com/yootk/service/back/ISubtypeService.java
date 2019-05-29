package com.yootk.service.back;

import com.yootk.vo.Subtype;

import java.util.List;
import java.util.Map;

public interface ISubtypeService {

    public List<Subtype> findAllByWitem(Long wiid) throws Exception;

}
