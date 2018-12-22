package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillVicQueryParam;
import com.whu.pro.mapper.result.KillVicQueryResult;

public interface KillVicQueryDao {
    
    void InsertElement(KillVicQueryParam params);

    ArrayList<KillVicQueryResult> selectMaxId();
}
