package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnSubQueryParam;
import com.whu.pro.mapper.result.BurnSubQueryResult;

public interface BurnSubQueryService {

    void InsertElement(BurnSubQueryParam params);

    ArrayList<BurnSubQueryResult> selectMaxId();
}
