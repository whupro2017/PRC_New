package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnSourQueryParam;
import com.whu.pro.mapper.result.BurnSourQueryResult;

public interface BurnSourQueryService {

    void InsertElement(BurnSourQueryParam params);

    ArrayList<BurnSourQueryResult> selectMaxId();

    ArrayList<BurnSourQueryResult> selectAllElement(BurnSourQueryParam params);

    ArrayList<BurnSourQueryResult> GetElementInfo(BurnSourQueryParam params);

    void UpdateElement(BurnSourQueryParam params);

    void DeleteElement(BurnSourQueryParam params);
}

