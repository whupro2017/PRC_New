package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.MatDnaQueryDao;
import com.whu.pro.mapper.param.MatDnaQueryParam;
import com.whu.pro.mapper.result.MatDnaQueryResult;
import com.whu.pro.service.MatDnaQueryService;

@Service("MatDnaQueryService")
public class MatDnaQueryImpl implements MatDnaQueryService {
    @Resource
    MatDnaQueryDao mdqd;
    
    public void InsertElement(MatDnaQueryParam params) {
        mdqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<MatDnaQueryResult> selectAllElement(MatDnaQueryParam params) {
        ArrayList<MatDnaQueryResult> list = mdqd.selectAllElement(params);
        return list;
    }

    public ArrayList<MatDnaQueryResult> GetElementInfo(MatDnaQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<MatDnaQueryResult> list = mdqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(MatDnaQueryParam params) {
        // TODO Auto-generated method stub
        mdqd.UpdateElement(params);
    }

    public ArrayList<MatDnaQueryResult> selectMaxId() {
        ArrayList<MatDnaQueryResult> list = mdqd.selectMaxId();
        return list;
    }

    public void DeleteElement(MatDnaQueryParam params) {
        mdqd.DeleteElement(params);
        // TODO Auto-generated method stub
    }
}