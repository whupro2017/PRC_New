package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.ExpDynQueryDao;
import com.whu.pro.mapper.param.ExpDynQueryParam;
import com.whu.pro.mapper.result.ExpDynQueryResult;
import com.whu.pro.service.ExpDynQueryService;

@Service("ExpDynQueryService")
public class ExpDynQueryImpl implements ExpDynQueryService {
    @Resource
    ExpDynQueryDao edqd;
    
    public void InsertElement(ExpDynQueryParam params) {
        edqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<ExpDynQueryResult> selectMaxId() {
        ArrayList<ExpDynQueryResult> list = edqd.selectMaxId();
        return list;
    }
}