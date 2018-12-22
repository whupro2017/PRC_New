package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.MatAbsQueryParam;
import com.whu.pro.mapper.result.MatAbsQueryResult;

public interface MatAbsQueryDao {
    
    void InsertElement(MatAbsQueryParam params);
    
    ArrayList<MatAbsQueryResult> selectAllElement(MatAbsQueryParam params);

    ArrayList<MatAbsQueryResult> GetElementInfo(MatAbsQueryParam params);

    void UpdateElement(MatAbsQueryParam params);

    ArrayList<MatAbsQueryResult> selectMaxId();

    void DeleteElement(MatAbsQueryParam params);
}
