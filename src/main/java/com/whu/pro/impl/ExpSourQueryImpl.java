package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.ExpSourQueryDao;
import com.whu.pro.mapper.param.ExpSourQueryParam;
import com.whu.pro.mapper.result.ExpSourQueryResult;
import com.whu.pro.service.ExpSourQueryService;

@Service("ExpSourQueryService")
public class ExpSourQueryImpl implements ExpSourQueryService {
    @Resource
    ExpSourQueryDao esqd;
    
    public void InsertElement(ExpSourQueryParam params) {
        esqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<ExpSourQueryResult> selectMaxId() {
        ArrayList<ExpSourQueryResult> list = esqd.selectMaxId();
        return list;
    }

    @Override
    public ArrayList<ExpSourQueryResult> selectAllElement(ExpSourQueryParam params) {
        ArrayList<ExpSourQueryResult> list = esqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<ExpSourQueryResult> GetElementInfo(ExpSourQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<ExpSourQueryResult> list = esqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(ExpSourQueryParam params) {
        // TODO Auto-generated method stub
        esqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(ExpSourQueryParam params) {
        esqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}