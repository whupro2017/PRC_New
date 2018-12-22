package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillEnvQueryParam;
import com.whu.pro.mapper.result.KillEnvQueryResult;

public interface KillEnvQueryDao {
    
    void InsertElement(KillEnvQueryParam params);

    ArrayList<KillEnvQueryResult> selectMaxId();
}
