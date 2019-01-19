package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.BurnSubQueryDao;
import com.whu.pro.mapper.param.BurnSubQueryParam;
import com.whu.pro.mapper.result.BurnSubQueryResult;
import com.whu.pro.service.BurnSubQueryService;

@Service("BurnSubQueryService")
public class BurnSubQueryImpl implements BurnSubQueryService {
    @Resource
    BurnSubQueryDao bsqd;
    
    public void InsertElement(BurnSubQueryParam params) {
        bsqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<BurnSubQueryResult> selectMaxId() {
        ArrayList<BurnSubQueryResult> list = bsqd.selectMaxId();
        return list;
    }

    @Override
    public ArrayList<BurnSubQueryResult> selectAllElement(BurnSubQueryParam params) {
        ArrayList<BurnSubQueryResult> list = bsqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<BurnSubQueryResult> GetElementInfo(BurnSubQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<BurnSubQueryResult> list = bsqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(BurnSubQueryParam params) {
        // TODO Auto-generated method stub
        bsqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(BurnSubQueryParam params) {
        bsqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}