package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.MatFootQueryParam;
import com.whu.pro.mapper.result.MatFootQueryResult;

public interface MatFootQueryDao {
    
    void InsertElement(MatFootQueryParam params);
    
    ArrayList<MatFootQueryResult> selectAllElement(MatFootQueryParam params);

    ArrayList<MatFootQueryResult> GetElementInfo(MatFootQueryParam params);

    void UpdateElement(MatFootQueryParam params);

    ArrayList<MatFootQueryResult> selectMaxId();

    void DeleteElement(MatFootQueryParam params);
}
