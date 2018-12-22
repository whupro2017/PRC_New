package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.MatInqQueryDao;
import com.whu.pro.mapper.param.MatInqQueryParam;
import com.whu.pro.mapper.result.MatInqQueryResult;
import com.whu.pro.service.MatInqQueryService;

@Service("MatInqQueryService")
public class MatInqQueryImpl implements MatInqQueryService {
    @Resource
    MatInqQueryDao miqd;
    
    public void InsertElement(MatInqQueryParam params) {
        miqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<MatInqQueryResult> selectAllElement(MatInqQueryParam params) {
        ArrayList<MatInqQueryResult> list = miqd.selectAllElement(params);
        return list;
    }

    public ArrayList<MatInqQueryResult> GetElementInfo(MatInqQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<MatInqQueryResult> list = miqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(MatInqQueryParam params) {
        // TODO Auto-generated method stub
        miqd.UpdateElement(params);
    }

    public ArrayList<MatInqQueryResult> selectMaxId() {
        ArrayList<MatInqQueryResult> list = miqd.selectMaxId();
        return list;
    }

    public void DeleteElement(MatInqQueryParam params) {
        miqd.DeleteElement(params);
        // TODO Auto-generated method stub
    }
}