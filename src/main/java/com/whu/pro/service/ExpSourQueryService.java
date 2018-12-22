package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.ExpSourQueryParam;
import com.whu.pro.mapper.result.ExpSourQueryResult;

public interface ExpSourQueryService {

    void InsertElement(ExpSourQueryParam params);

    ArrayList<ExpSourQueryResult> selectMaxId();
}
