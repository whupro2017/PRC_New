package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnFuelQueryParam;
import com.whu.pro.mapper.result.BurnFuelQueryResult;

public interface BurnFuelQueryDao {
    
    void InsertElement(BurnFuelQueryParam params);

    ArrayList<BurnFuelQueryResult> selectMaxId();
}
