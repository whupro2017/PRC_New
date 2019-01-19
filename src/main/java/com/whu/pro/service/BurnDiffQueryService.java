package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnDiffQueryParam;
import com.whu.pro.mapper.result.BurnDiffQueryResult;

public interface BurnDiffQueryService {

    void InsertElement(BurnDiffQueryParam params);

    ArrayList<BurnDiffQueryResult> selectMaxId();

    ArrayList<BurnDiffQueryResult> selectAllElement(BurnDiffQueryParam params);

    ArrayList<BurnDiffQueryResult> GetElementInfo(BurnDiffQueryParam params);

    void UpdateElement(BurnDiffQueryParam params);

    void DeleteElement(BurnDiffQueryParam params);
}
