package com.yootk.service.back.impl;

import com.yootk.common.annotation.Autowired;
import com.yootk.common.annotation.Service;
import com.yootk.common.service.abs.AbstractService;
import com.yootk.dao.INewsDAO;
import com.yootk.service.back.INewsServiceBack;
import com.yootk.vo.News;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class NewsServiceBackImpl extends AbstractService implements INewsServiceBack {
    @Autowired
    private INewsDAO newsDAO ;
    @Override
    public boolean add(News vo) throws Exception {
        return this.newsDAO.doCreate(vo);
    }

    @Override
    public boolean edit(News vo) throws Exception {
        if(vo.getPhoto()==null || "".equals(vo.getPhoto())){
            vo.setPhoto(this.newsDAO.findById(vo.getNid()).getPhoto());
        }
        return this.newsDAO.doEdit(vo);
    }

    @Override
    public boolean delete(Set<Long> longs) throws Exception {
        return this.newsDAO.doRemove(longs) ;
    }

    @Override
    public News get(Long nid) throws Exception {
        return this.newsDAO.findById(nid);
    }

    @Override
    public Map<String, Object> list(Long currentPage, Integer lineSize, String column, String keyword) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if(isEmpty(column,keyword)){
            map.put("allNews",this.newsDAO.findSplit(currentPage,lineSize)) ;
            map.put("allRecorders",this.newsDAO.getAllCount()) ;
       }else{
            map.put("allNews",this.newsDAO.findSplit(currentPage,lineSize,column,keyword)) ;
            map.put("allRecorders",this.newsDAO.getAllCount(column,keyword)) ;
       }
        return map ;
    }

}
