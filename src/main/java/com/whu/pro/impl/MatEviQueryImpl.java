package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.MatEviQueryDao;
import com.whu.pro.mapper.param.MatEviQueryParam;
import com.whu.pro.mapper.result.MatEviQueryResult;
import com.whu.pro.service.MatEviQueryService;

@Service("MatEviQueryService")
public class MatEviQueryImpl implements MatEviQueryService {
    @Resource
    MatEviQueryDao meqd;
    
    public void InsertElement(MatEviQueryParam params) {
        meqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<MatEviQueryResult> selectAllElement(MatEviQueryParam params) {
        ArrayList<MatEviQueryResult> list = meqd.selectAllElement(params);
        return list;
    }

    public ArrayList<MatEviQueryResult> GetElementInfo(MatEviQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<MatEviQueryResult> list = meqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(MatEviQueryParam params) {
        // TODO Auto-generated method stub
        meqd.UpdateElement(params);
    }

    public ArrayList<MatEviQueryResult> selectMaxId() {
        ArrayList<MatEviQueryResult> list = meqd.selectMaxId();
        return list;
    }

    public void DeleteElement(MatEviQueryParam params) {
        meqd.DeleteElement(params);
        // TODO Auto-generated method stub
    }
}