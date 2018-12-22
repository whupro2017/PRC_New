package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.MatFootQueryParam;
import com.whu.pro.mapper.result.MatFootQueryResult;

public interface MatFootQueryService {

    void InsertElement(MatFootQueryParam params);
    
    ArrayList<MatFootQueryResult> selectAllElement(MatFootQueryParam params);

    ArrayList<MatFootQueryResult> GetElementInfo(MatFootQueryParam params);

    void UpdateElement(MatFootQueryParam params);

    ArrayList<MatFootQueryResult> selectMaxId();

    void DeleteElement(MatFootQueryParam params);
}
