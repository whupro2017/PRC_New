package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.BurnSubQueryDao;
import com.whu.pro.mapper.param.BurnSubQueryParam;
import com.whu.pro.mapper.result.BurnSubQueryResult;
import com.whu.pro.service.BurnSubQueryService;

@Service("BurnSubQueryService")
public class BurnSubQueryImpl implements BurnSubQueryService {
    @Resource
    BurnSubQueryDao bsqd;
    
    public void InsertElement(BurnSubQueryParam params) {
        bsqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<BurnSubQueryResult> selectMaxId() {
        ArrayList<BurnSubQueryResult> list = bsqd.selectMaxId();
        return list;
    }
}