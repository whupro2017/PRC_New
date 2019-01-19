package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.ExpSubQueryDao;
import com.whu.pro.mapper.param.ExpSubQueryParam;
import com.whu.pro.mapper.result.ExpSubQueryResult;
import com.whu.pro.service.ExpSubQueryService;

@Service("ExpSubQueryService")
public class ExpSubQueryImpl implements ExpSubQueryService {
    @Resource
    ExpSubQueryDao esqd;
    
    public void InsertElement(ExpSubQueryParam params) {
        esqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<ExpSubQueryResult> selectMaxId() {
        ArrayList<ExpSubQueryResult> list = esqd.selectMaxId();
        return list;
    }

    @Override
    public ArrayList<ExpSubQueryResult> selectAllElement(ExpSubQueryParam params) {
        ArrayList<ExpSubQueryResult> list = esqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<ExpSubQueryResult> GetElementInfo(ExpSubQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<ExpSubQueryResult> list = esqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(ExpSubQueryParam params) {
        // TODO Auto-generated method stub
        esqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(ExpSubQueryParam params) {
        esqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}