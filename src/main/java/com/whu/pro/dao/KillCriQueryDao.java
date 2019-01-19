package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillCriQueryParam;
import com.whu.pro.mapper.result.KillCriQueryResult;

public interface KillCriQueryDao {
    
    void InsertElement(KillCriQueryParam params);

    ArrayList<KillCriQueryResult> selectMaxId();

    ArrayList<KillCriQueryResult> selectAllElement(KillCriQueryParam params);

    ArrayList<KillCriQueryResult> GetElementInfo(KillCriQueryParam params);

    void UpdateElement(KillCriQueryParam params);

    void DeleteElement(KillCriQueryParam params);
}
