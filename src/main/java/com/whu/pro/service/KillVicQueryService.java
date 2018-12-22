package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillVicQueryParam;
import com.whu.pro.mapper.result.KillVicQueryResult;

public interface KillVicQueryService {

    void InsertElement(KillVicQueryParam params);

    ArrayList<KillVicQueryResult> selectMaxId();
}
