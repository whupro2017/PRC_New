package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.MatInqQueryParam;
import com.whu.pro.mapper.result.MatInqQueryResult;

public interface MatInqQueryDao {
    
    void InsertElement(MatInqQueryParam params);
    
    ArrayList<MatInqQueryResult> selectAllElement(MatInqQueryParam params);

    ArrayList<MatInqQueryResult> GetElementInfo(MatInqQueryParam params);

    void UpdateElement(MatInqQueryParam params);

    ArrayList<MatInqQueryResult> selectMaxId();

    void DeleteElement(MatInqQueryParam params);
}
