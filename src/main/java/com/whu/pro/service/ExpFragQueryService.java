package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.ExpFragQueryParam;
import com.whu.pro.mapper.result.ExpFragQueryResult;

public interface ExpFragQueryService {

    void InsertElement(ExpFragQueryParam params);

    ArrayList<ExpFragQueryResult> selectMaxId();
}
