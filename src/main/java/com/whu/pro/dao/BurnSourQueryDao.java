package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnSourQueryParam;
import com.whu.pro.mapper.result.BurnSourQueryResult;

public interface BurnSourQueryDao {
    
    void InsertElement(BurnSourQueryParam params);

    ArrayList<BurnSourQueryResult> selectMaxId();
}
