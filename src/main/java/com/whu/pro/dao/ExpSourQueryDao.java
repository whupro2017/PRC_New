package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.ExpSourQueryParam;
import com.whu.pro.mapper.result.ExpSourQueryResult;

public interface ExpSourQueryDao {
    
    void InsertElement(ExpSourQueryParam params);

    ArrayList<ExpSourQueryResult> selectMaxId();

    ArrayList<ExpSourQueryResult> selectAllElement(ExpSourQueryParam params);

    ArrayList<ExpSourQueryResult> GetElementInfo(ExpSourQueryParam params);

    void UpdateElement(ExpSourQueryParam params);

    void DeleteElement(ExpSourQueryParam params);
}
