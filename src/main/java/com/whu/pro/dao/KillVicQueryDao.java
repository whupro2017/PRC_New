package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillVicQueryParam;
import com.whu.pro.mapper.result.KillVicQueryResult;

public interface KillVicQueryDao {
    
    void InsertElement(KillVicQueryParam params);

    ArrayList<KillVicQueryResult> selectMaxId();

    ArrayList<KillVicQueryResult> selectAllElement(KillVicQueryParam params);

    ArrayList<KillVicQueryResult> GetElementInfo(KillVicQueryParam params);

    void UpdateElement(KillVicQueryParam params);

    void DeleteElement(KillVicQueryParam params);
}
