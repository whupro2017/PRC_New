package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.MatFingQueryParam;
import com.whu.pro.mapper.result.MatFingQueryResult;

public interface MatFingQueryDao {
    void InsertElement(MatFingQueryParam params);
    
    ArrayList<MatFingQueryResult> selectAllElement(MatFingQueryParam params);

    ArrayList<MatFingQueryResult> GetElementInfo(MatFingQueryParam params);

    void UpdateElement(MatFingQueryParam params);

    ArrayList<MatFingQueryResult> selectMaxId();

    void DeleteElement(MatFingQueryParam params);
}
