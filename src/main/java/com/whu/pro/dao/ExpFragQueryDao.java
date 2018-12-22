package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.ExpFragQueryParam;
import com.whu.pro.mapper.result.ExpFragQueryResult;

public interface ExpFragQueryDao {
    
    void InsertElement(ExpFragQueryParam params);

    ArrayList<ExpFragQueryResult> selectMaxId();
}
