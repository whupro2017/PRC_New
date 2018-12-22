package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.ExpDynQueryParam;
import com.whu.pro.mapper.result.ExpDynQueryResult;

public interface ExpDynQueryDao {
    
    void InsertElement(ExpDynQueryParam params);

    ArrayList<ExpDynQueryResult> selectMaxId();
}
