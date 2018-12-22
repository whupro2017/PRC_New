package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnSourQueryParam;
import com.whu.pro.mapper.result.BurnSourQueryResult;

public interface BurnSourQueryService {

    void InsertElement(BurnSourQueryParam params);

    ArrayList<BurnSourQueryResult> selectMaxId();
}
