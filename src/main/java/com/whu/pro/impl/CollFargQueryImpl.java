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

    @Override
    public ArrayList<CollFragQueryResult> selectAllElement(CollFragQueryParam params) {
        ArrayList<CollFragQueryResult> list = cfqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<CollFragQueryResult> GetElementInfo(CollFragQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<CollFragQueryResult> list = cfqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(CollFragQueryParam params) {
        // TODO Auto-generated method stub
        cfqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(CollFragQueryParam params) {
        cfqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}