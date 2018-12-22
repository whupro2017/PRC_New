package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.CollObjQueryDao;
import com.whu.pro.mapper.param.CollObjQueryParam;
import com.whu.pro.mapper.result.CollObjQueryResult;
import com.whu.pro.service.CollObjQueryService;

@Service("CollObjQueryService")
public class CollObjQueryImpl implements CollObjQueryService {
    @Resource
    CollObjQueryDao coqd;
    
    public void InsertElement(CollObjQueryParam params) {
        coqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<CollObjQueryResult> selectMaxId() {
        ArrayList<CollObjQueryResult> list = coqd.selectMaxId();
        return list;
    }
}