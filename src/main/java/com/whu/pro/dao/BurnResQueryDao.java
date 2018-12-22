package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnResQueryParam;
import com.whu.pro.mapper.result.BurnResQueryResult;

public interface BurnResQueryDao {
    
    void InsertElement(BurnResQueryParam params);

    ArrayList<BurnResQueryResult> selectMaxId();
}
