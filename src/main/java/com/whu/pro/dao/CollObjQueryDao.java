package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CollObjQueryParam;
import com.whu.pro.mapper.result.CollObjQueryResult;

public interface CollObjQueryDao {
    
    void InsertElement(CollObjQueryParam params);

    ArrayList<CollObjQueryResult> selectMaxId();
}
