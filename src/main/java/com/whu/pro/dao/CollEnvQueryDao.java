package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CollEnvQueryParam;
import com.whu.pro.mapper.result.CollEnvQueryResult;

public interface CollEnvQueryDao {
    
    void InsertElement(CollEnvQueryParam params);

    ArrayList<CollEnvQueryResult> selectMaxId();
}
