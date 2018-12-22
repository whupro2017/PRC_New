package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.MatEviQueryParam;
import com.whu.pro.mapper.result.MatEviQueryResult;

public interface MatEviQueryService {

    void InsertElement(MatEviQueryParam params);
    
    ArrayList<MatEviQueryResult> selectAllElement(MatEviQueryParam params);

    ArrayList<MatEviQueryResult> GetElementInfo(MatEviQueryParam params);

    void UpdateElement(MatEviQueryParam params);

    ArrayList<MatEviQueryResult> selectMaxId();

    void DeleteElement(MatEviQueryParam params);
}
