package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.MatFootQueryDao;
import com.whu.pro.mapper.param.MatFootQueryParam;
import com.whu.pro.mapper.result.MatFootQueryResult;
import com.whu.pro.service.MatFootQueryService;

@Service("MatFootQueryService")
public class MatFootQueryImpl implements MatFootQueryService {
    @Resource
    MatFootQueryDao mfmqd;
    
    public void InsertElement(MatFootQueryParam params) {
        mfmqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<MatFootQueryResult> selectAllElement(MatFootQueryParam params) {
        ArrayList<MatFootQueryResult> list = mfmqd.selectAllElement(params);
        return list;
    }

    public ArrayList<MatFootQueryResult> GetElementInfo(MatFootQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<MatFootQueryResult> list = mfmqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(MatFootQueryParam params) {
        // TODO Auto-generated method stub
        mfmqd.UpdateElement(params);
    }

    public ArrayList<MatFootQueryResult> selectMaxId() {
        ArrayList<MatFootQueryResult> list = mfmqd.selectMaxId();
        return list;
    }

    public void DeleteElement(MatFootQueryParam params) {
        mfmqd.DeleteElement(params);
        // TODO Auto-generated method stub
    }
}