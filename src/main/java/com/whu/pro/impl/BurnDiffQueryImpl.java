package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.BurnDiffQueryDao;
import com.whu.pro.mapper.param.BurnDiffQueryParam;
import com.whu.pro.mapper.result.BurnDiffQueryResult;
import com.whu.pro.service.BurnDiffQueryService;

@Service("BurnDiffQueryService")
public class BurnDiffQueryImpl implements BurnDiffQueryService {
    @Resource
    BurnDiffQueryDao bdqd;
    
    public void InsertElement(BurnDiffQueryParam params) {
        bdqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<BurnDiffQueryResult> selectMaxId() {
        ArrayList<BurnDiffQueryResult> list = bdqd.selectMaxId();
        return list;
    }
}