package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.ExpSubQueryParam;
import com.whu.pro.mapper.result.ExpSubQueryResult;

public interface ExpSubQueryService {

    void InsertElement(ExpSubQueryParam params);

    ArrayList<ExpSubQueryResult> selectMaxId();

    ArrayList<ExpSubQueryResult> selectAllElement(ExpSubQueryParam params);

    ArrayList<ExpSubQueryResult> GetElementInfo(ExpSubQueryParam params);

    void UpdateElement(ExpSubQueryParam params);

    void DeleteElement(ExpSubQueryParam params);
}
