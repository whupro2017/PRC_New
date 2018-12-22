package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.MatFingQueryDao;
import com.whu.pro.mapper.param.MatFingQueryParam;
import com.whu.pro.mapper.result.MatFingQueryResult;
import com.whu.pro.service.MatFingQueryService;

@Service("MatFingQueryService")
public class MatFingQueryImpl implements MatFingQueryService {
    @Resource
    MatFingQueryDao mfpqd;
    
    public void InsertElement(MatFingQueryParam params) {
        mfpqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<MatFingQueryResult> selectAllElement(MatFingQueryParam params) {
        ArrayList<MatFingQueryResult> list = mfpqd.selectAllElement(params);
        return list;
    }

    public ArrayList<MatFingQueryResult> GetElementInfo(MatFingQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<MatFingQueryResult> list = mfpqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(MatFingQueryParam params) {
        // TODO Auto-generated method stub
        mfpqd.UpdateElement(params);
    }

    public ArrayList<MatFingQueryResult> selectMaxId() {
        ArrayList<MatFingQueryResult> list = mfpqd.selectMaxId();
        return list;
    }

    public void DeleteElement(MatFingQueryParam params) {
        mfpqd.DeleteElement(params);
        // TODO Auto-generated method stub
    }
}