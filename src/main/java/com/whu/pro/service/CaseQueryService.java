package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CaseQueryParam;
import com.whu.pro.mapper.result.CaseQueryResult;

public interface CaseQueryService {
    ArrayList<CaseQueryResult> getAllCaseByKeyword(CaseQueryParam params);

    ArrayList<CaseQueryResult> getAllCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> getBurnCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> getBomCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> getGrabCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> getKillCase(CaseQueryParam params);

    ArrayList<CaseQueryResult> IdIsExsit(CaseQueryParam params);

    void InsertCase(CaseQueryParam params);
}
