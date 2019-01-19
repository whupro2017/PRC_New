package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.CollSubQueryDao;
import com.whu.pro.mapper.param.CollSubQueryParam;
import com.whu.pro.mapper.result.CollSubQueryResult;
import com.whu.pro.service.CollSubQueryService;

@Service("CollSubQueryService")
public class CollSubQueryImpl implements CollSubQueryService {
    @Resource
    CollSubQueryDao csqd;
    
    public void InsertElement(CollSubQueryParam params) {
        csqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<CollSubQueryResult> selectMaxId() {
        ArrayList<CollSubQueryResult> list = csqd.selectMaxId();
        return list;
    }

    @Override
    public ArrayList<CollSubQueryResult> selectAllElement(CollSubQueryParam params) {
        ArrayList<CollSubQueryResult> list = csqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<CollSubQueryResult> GetElementInfo(CollSubQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<CollSubQueryResult> list = csqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(CollSubQueryParam params) {
        // TODO Auto-generated method stub
        csqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(CollSubQueryParam params) {
        csqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}