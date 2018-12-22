package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CollFragQueryParam;
import com.whu.pro.mapper.result.CollFragQueryResult;

public interface CollFragQueryDao {
    
    void InsertElement(CollFragQueryParam params);

    ArrayList<CollFragQueryResult> selectMaxId();
}
