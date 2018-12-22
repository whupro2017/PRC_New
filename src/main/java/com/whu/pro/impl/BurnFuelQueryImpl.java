package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.BurnFuelQueryDao;
import com.whu.pro.mapper.param.BurnFuelQueryParam;
import com.whu.pro.mapper.result.BurnFuelQueryResult;
import com.whu.pro.service.BurnFuelQueryService;

@Service("BurnFuelQueryService")
public class BurnFuelQueryImpl implements BurnFuelQueryService {
    @Resource
    BurnFuelQueryDao bfqd;
    
    public void InsertElement(BurnFuelQueryParam params) {
        bfqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<BurnFuelQueryResult> selectMaxId() {
        ArrayList<BurnFuelQueryResult> list = bfqd.selectMaxId();
        return list;
    }
}