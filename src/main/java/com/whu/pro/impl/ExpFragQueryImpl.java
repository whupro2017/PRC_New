package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.ExpFragQueryDao;
import com.whu.pro.mapper.param.ExpFragQueryParam;
import com.whu.pro.mapper.result.ExpFragQueryResult;
import com.whu.pro.service.ExpFragQueryService;

@Service("ExpFragQueryService")
public class ExpFragQueryImpl implements ExpFragQueryService {
    @Resource
    ExpFragQueryDao efqd;
    
    public void InsertElement(ExpFragQueryParam params) {
        efqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<ExpFragQueryResult> selectMaxId() {
        ArrayList<ExpFragQueryResult> list = efqd.selectMaxId();
        return list;
    }
}