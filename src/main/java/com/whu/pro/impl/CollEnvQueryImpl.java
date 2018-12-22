package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.CollEnvQueryDao;
import com.whu.pro.mapper.param.CollEnvQueryParam;
import com.whu.pro.mapper.result.CollEnvQueryResult;
import com.whu.pro.service.CollEnvQueryService;

@Service("CollEnvQueryService")
public class CollEnvQueryImpl implements CollEnvQueryService {
    @Resource
    CollEnvQueryDao ceqd;
    
    public void InsertElement(CollEnvQueryParam params) {
        ceqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<CollEnvQueryResult> selectMaxId() {
        ArrayList<CollEnvQueryResult> list = ceqd.selectMaxId();
        return list;
    }
}