package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.MatAbsQueryDao;
import com.whu.pro.mapper.param.MatAbsQueryParam;
import com.whu.pro.mapper.result.MatAbsQueryResult;
import com.whu.pro.service.MatAbsQueryService;

@Service("MatAbsQueryService")
public class MatAbsQueryImpl implements MatAbsQueryService {
    @Resource
    MatAbsQueryDao maqd;
    
    public void InsertElement(MatAbsQueryParam params) {
        maqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<MatAbsQueryResult> selectAllElement(MatAbsQueryParam params) {
        ArrayList<MatAbsQueryResult> list = maqd.selectAllElement(params);
        return list;
    }

    public ArrayList<MatAbsQueryResult> GetElementInfo(MatAbsQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<MatAbsQueryResult> list = maqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(MatAbsQueryParam params) {
        // TODO Auto-generated method stub
        maqd.UpdateElement(params);
    }

    public ArrayList<MatAbsQueryResult> selectMaxId() {
        ArrayList<MatAbsQueryResult> list = maqd.selectMaxId();
        return list;
    }

    public void DeleteElement(MatAbsQueryParam params) {
        maqd.DeleteElement(params);
        // TODO Auto-generated method stub
    }
}