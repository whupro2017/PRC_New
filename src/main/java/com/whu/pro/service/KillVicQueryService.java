package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillVicQueryParam;
import com.whu.pro.mapper.result.KillVicQueryResult;

public interface KillVicQueryService {

    void InsertElement(KillVicQueryParam params);

    ArrayList<KillVicQueryResult> selectMaxId();

    ArrayList<KillVicQueryResult> selectAllElement(KillVicQueryParam params);

    ArrayList<KillVicQueryResult> GetElementInfo(KillVicQueryParam params);

    void UpdateElement(KillVicQueryParam params);

    void DeleteElement(KillVicQueryParam params);
}
