package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.BurnSourQueryDao;
import com.whu.pro.mapper.param.BurnSourQueryParam;
import com.whu.pro.mapper.result.BurnSourQueryResult;
import com.whu.pro.service.BurnSourQueryService;

@Service("BurnSourQueryService")
public class BurnSourQueryImpl implements BurnSourQueryService {
    @Resource
    BurnSourQueryDao bsqd;
    
    public void InsertElement(BurnSourQueryParam params) {
        bsqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<BurnSourQueryResult> selectMaxId() {
        ArrayList<BurnSourQueryResult> list = bsqd.selectMaxId();
        return list;
    }
}