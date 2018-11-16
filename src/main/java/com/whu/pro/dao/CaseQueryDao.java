package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CaseQueryParam;
import com.whu.pro.mapper.result.CaseQueryResult;

public interface CaseQueryDao {
    ArrayList<CaseQueryResult> getAllCaseByKeyword(CaseQueryParam params);

    ArrayList<CaseQueryResult> selectAllCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> selectBurnCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> selectBomCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> selectGrabCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> selectKillCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> IdIsExsit(CaseQueryParam params);

    void InsertCase(CaseQueryParam params);
}
