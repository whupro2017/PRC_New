package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.CaseQueryDao;
import com.whu.pro.mapper.param.CaseQueryParam;
import com.whu.pro.mapper.result.CaseQueryResult;
import com.whu.pro.service.CaseQueryService;

@Service("CaseQueryService")
public class CaseQueryImpl implements CaseQueryService {
    @Resource
    CaseQueryDao cqd;

    public ArrayList<CaseQueryResult> getBurnCase(CaseQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<CaseQueryResult> list = cqd.selectBurnCase(params);
        return list;
    }

    public ArrayList<CaseQueryResult> getBomCase(CaseQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<CaseQueryResult> list = cqd.selectBomCase(params);
        return list;
    }

    public ArrayList<CaseQueryResult> getGrabCase(CaseQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<CaseQueryResult> list = cqd.selectGrabCase(params);
        return list;
    }

    public ArrayList<CaseQueryResult> getKillCase(CaseQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<CaseQueryResult> list = cqd.selectKillCase(params);
        return list;
    }

    public ArrayList<CaseQueryResult> getAllCase(CaseQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<CaseQueryResult> list = cqd.selectAllCase(params);
        return list;
    }

    public ArrayList<CaseQueryResult> IdIsExsit(CaseQueryParam params) {
        // TODO Auto-generated method stub
        ArrayList<CaseQueryResult> list = cqd.IdIsExsit(params);
        return list;
    }

    public void InsertCase(CaseQueryParam params) {
        cqd.InsertCase(params);
        // TODO Auto-generated method stub
    }

}
