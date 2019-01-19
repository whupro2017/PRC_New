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

    @Override
    public ArrayList<KillEnvQueryResult> selectAllElement(KillEnvQueryParam params) {
        ArrayList<KillEnvQueryResult> list = keqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<KillEnvQueryResult> GetElementInfo(KillEnvQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<KillEnvQueryResult> list = keqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(KillEnvQueryParam params) {
        // TODO Auto-generated method stub
        keqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(KillEnvQueryParam params) {
        keqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}