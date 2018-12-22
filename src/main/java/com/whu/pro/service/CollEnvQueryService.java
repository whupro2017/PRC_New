package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CollEnvQueryParam;
import com.whu.pro.mapper.result.CollEnvQueryResult;

public interface CollEnvQueryService {

    void InsertElement(CollEnvQueryParam params);

    ArrayList<CollEnvQueryResult> selectMaxId();
}
