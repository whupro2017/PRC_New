package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CollSubQueryParam;
import com.whu.pro.mapper.result.CollSubQueryResult;

public interface CollSubQueryDao {
    
    void InsertElement(CollSubQueryParam params);

    ArrayList<CollSubQueryResult> selectMaxId();

    ArrayList<CollSubQueryResult> selectAllElement(CollSubQueryParam params);

    ArrayList<CollSubQueryResult> GetElementInfo(CollSubQueryParam params);

    void UpdateElement(CollSubQueryParam params);

    void DeleteElement(CollSubQueryParam params);
}
