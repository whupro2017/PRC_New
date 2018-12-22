package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.MatEviQueryParam;
import com.whu.pro.mapper.result.MatEviQueryResult;

public interface MatEviQueryDao {
    
    void InsertElement(MatEviQueryParam params);
    
    ArrayList<MatEviQueryResult> selectAllElement(MatEviQueryParam params);

    ArrayList<MatEviQueryResult> GetElementInfo(MatEviQueryParam params);

    void UpdateElement(MatEviQueryParam params);

    ArrayList<MatEviQueryResult> selectMaxId();

    void DeleteElement(MatEviQueryParam params);
}
