package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillEnvQueryParam;
import com.whu.pro.mapper.result.KillEnvQueryResult;

public interface KillEnvQueryService {

    void InsertElement(KillEnvQueryParam params);

    ArrayList<KillEnvQueryResult> selectMaxId();
}
