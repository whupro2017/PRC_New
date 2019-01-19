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

    @Override
    public ArrayList<CollEnvQueryResult> selectAllElement(CollEnvQueryParam params) {
        ArrayList<CollEnvQueryResult> list = ceqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<CollEnvQueryResult> GetElementInfo(CollEnvQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<CollEnvQueryResult> list = ceqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(CollEnvQueryParam params) {
        // TODO Auto-generated method stub
        ceqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(CollEnvQueryParam params) {
        ceqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}