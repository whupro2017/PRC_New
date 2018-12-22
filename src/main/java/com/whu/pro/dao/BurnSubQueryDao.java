package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnSubQueryParam;
import com.whu.pro.mapper.result.BurnSubQueryResult;

public interface BurnSubQueryDao {
    
    void InsertElement(BurnSubQueryParam params);

    ArrayList<BurnSubQueryResult> selectMaxId();
}
