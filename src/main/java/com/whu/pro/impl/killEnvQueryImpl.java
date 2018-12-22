package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.KillEnvQueryDao;
import com.whu.pro.mapper.param.KillEnvQueryParam;
import com.whu.pro.mapper.result.KillEnvQueryResult;
import com.whu.pro.service.KillEnvQueryService;

@Service("KillEnvQueryService")
public class killEnvQueryImpl implements KillEnvQueryService {
    @Resource
    KillEnvQueryDao keqd;
    
    public void InsertElement(KillEnvQueryParam params) {
        keqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<KillEnvQueryResult> selectMaxId() {
        ArrayList<KillEnvQueryResult> list = keqd.selectMaxId();
        return list;
    }
}