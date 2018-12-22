package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.ExpSubQueryParam;
import com.whu.pro.mapper.result.ExpSubQueryResult;

public interface ExpSubQueryDao {
    
    void InsertElement(ExpSubQueryParam params);

    ArrayList<ExpSubQueryResult> selectMaxId();
}
