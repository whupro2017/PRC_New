package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.MatDnaQueryParam;
import com.whu.pro.mapper.result.MatDnaQueryResult;

public interface MatDnaQueryDao {
    
    void InsertElement(MatDnaQueryParam params);
    
    ArrayList<MatDnaQueryResult> selectAllElement(MatDnaQueryParam params);

    ArrayList<MatDnaQueryResult> GetElementInfo(MatDnaQueryParam params);

    void UpdateElement(MatDnaQueryParam params);

    ArrayList<MatDnaQueryResult> selectMaxId();

    void DeleteElement(MatDnaQueryParam params);
}
