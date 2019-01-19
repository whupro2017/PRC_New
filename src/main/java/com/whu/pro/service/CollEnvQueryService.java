package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CollEnvQueryParam;
import com.whu.pro.mapper.result.CollEnvQueryResult;

public interface CollEnvQueryService {

    void InsertElement(CollEnvQueryParam params);

    ArrayList<CollEnvQueryResult> selectMaxId();

    ArrayList<CollEnvQueryResult> selectAllElement(CollEnvQueryParam params);

    ArrayList<CollEnvQueryResult> GetElementInfo(CollEnvQueryParam params);

    void UpdateElement(CollEnvQueryParam params);

    void DeleteElement(CollEnvQueryParam params);
}
