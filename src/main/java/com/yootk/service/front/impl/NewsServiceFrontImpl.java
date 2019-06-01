package com.yootk.service.front.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.INewsDAO;
import com.yootk.service.front.INewsServiceFront;
import com.yootk.vo.News;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceFrontImpl extends AbstractService implements INewsServiceFront {
    @Autowired
    private INewsDAO newsDAO;

    @Override
    public List<News> getListForIndex() throws Exception {
        return newsDAO.findAllForIndex();
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("allNews", this.newsDAO.findSplitForFront(currentPage, lineSize));
        map.put("allRecorders", this.newsDAO.getAllCountForFront());
        return map;
    }
}
