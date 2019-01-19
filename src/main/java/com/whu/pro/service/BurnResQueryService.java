package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnResQueryParam;
import com.whu.pro.mapper.result.BurnResQueryResult;

public interface BurnResQueryService {

    void InsertElement(BurnResQueryParam params);

    ArrayList<BurnResQueryResult> selectMaxId();

    ArrayList<BurnResQueryResult> selectAllElement(BurnResQueryParam params);

    ArrayList<BurnResQueryResult> GetElementInfo(BurnResQueryParam params);

    void UpdateElement(BurnResQueryParam params);

    void DeleteElement(BurnResQueryParam params);
}
