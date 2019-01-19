package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.KillVicQueryDao;
import com.whu.pro.mapper.param.KillVicQueryParam;
import com.whu.pro.mapper.result.KillVicQueryResult;
import com.whu.pro.service.KillVicQueryService;

@Service("KillVicQueryService")
public class killVicQueryImpl implements KillVicQueryService {
    @Resource
    KillVicQueryDao kvqd;
    
    public void InsertElement(KillVicQueryParam params) {
        kvqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<KillVicQueryResult> selectMaxId() {
        ArrayList<KillVicQueryResult> list = kvqd.selectMaxId();
        return list;
    }

    @Override
    public ArrayList<KillVicQueryResult> selectAllElement(KillVicQueryParam params) {
        ArrayList<KillVicQueryResult> list = kvqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<KillVicQueryResult> GetElementInfo(KillVicQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<KillVicQueryResult> list = kvqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(KillVicQueryParam params) {
        // TODO Auto-generated method stub
        kvqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(KillVicQueryParam params) {
        kvqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}