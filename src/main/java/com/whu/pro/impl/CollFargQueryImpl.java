package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.CollFragQueryDao;
import com.whu.pro.mapper.param.CollFragQueryParam;
import com.whu.pro.mapper.result.CollFragQueryResult;
import com.whu.pro.service.CollFragQueryService;

@Service("CollFragQueryService")
public class CollFargQueryImpl implements CollFragQueryService {
    @Resource
    CollFragQueryDao cfqd;
    
    public void InsertElement(CollFragQueryParam params) {
        cfqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<CollFragQueryResult> selectMaxId() {
        ArrayList<CollFragQueryResult> list = cfqd.selectMaxId();
        return list;
    }
}