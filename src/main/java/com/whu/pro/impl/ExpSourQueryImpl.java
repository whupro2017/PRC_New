package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.ExpSourQueryDao;
import com.whu.pro.mapper.param.ExpSourQueryParam;
import com.whu.pro.mapper.result.ExpSourQueryResult;
import com.whu.pro.service.ExpSourQueryService;

@Service("ExpSourQueryService")
public class ExpSourQueryImpl implements ExpSourQueryService {
    @Resource
    ExpSourQueryDao esqd;
    
    public void InsertElement(ExpSourQueryParam params) {
        esqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<ExpSourQueryResult> selectMaxId() {
        ArrayList<ExpSourQueryResult> list = esqd.selectMaxId();
        return list;
    }
}