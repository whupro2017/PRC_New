package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.BurnResQueryDao;
import com.whu.pro.mapper.param.BurnResQueryParam;
import com.whu.pro.mapper.result.BurnResQueryResult;
import com.whu.pro.service.BurnResQueryService;

@Service("BurnResQueryService")
public class BurnResQueryImpl implements BurnResQueryService {
    @Resource
    BurnResQueryDao brqd;
    
    public void InsertElement(BurnResQueryParam params) {
        brqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<BurnResQueryResult> selectMaxId() {
        ArrayList<BurnResQueryResult> list = brqd.selectMaxId();
        return list;
    }

    @Override
    public ArrayList<BurnResQueryResult> selectAllElement(BurnResQueryParam params) {
        ArrayList<BurnResQueryResult> list = brqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<BurnResQueryResult> GetElementInfo(BurnResQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<BurnResQueryResult> list = brqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(BurnResQueryParam params) {
        // TODO Auto-generated method stub
        brqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(BurnResQueryParam params) {
        brqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}