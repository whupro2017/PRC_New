package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.KillCriQueryDao;
import com.whu.pro.mapper.param.KillCriQueryParam;
import com.whu.pro.mapper.result.KillCriQueryResult;
import com.whu.pro.service.KillCriQueryService;

@Service("KillCriQueryService")
public class killCriQueryImpl implements KillCriQueryService {
    @Resource
    KillCriQueryDao kcqd;
    
    public void InsertElement(KillCriQueryParam params) {
        kcqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<KillCriQueryResult> selectMaxId() {
        ArrayList<KillCriQueryResult> list = kcqd.selectMaxId();
        return list;
    }

    @Override
    public ArrayList<KillCriQueryResult> selectAllElement(KillCriQueryParam params) {
        ArrayList<KillCriQueryResult> list = kcqd.selectAllElement(params);
        return list;
    }

    @Override
    public ArrayList<KillCriQueryResult> GetElementInfo(KillCriQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<KillCriQueryResult> list = kcqd.GetElementInfo(params);
        return list;
    }

    @Override
    public void UpdateElement(KillCriQueryParam params) {
        // TODO Auto-generated method stub
        kcqd.UpdateElement(params);
    }

    @Override
    public void DeleteElement(KillCriQueryParam params) {
        kcqd.DeleteElement(params);
        // TODO Auto-generated method stub

    }
}