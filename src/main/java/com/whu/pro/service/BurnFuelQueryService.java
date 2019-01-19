package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.BurnFuelQueryParam;
import com.whu.pro.mapper.result.BurnFuelQueryResult;

public interface BurnFuelQueryService {

    void InsertElement(BurnFuelQueryParam params);

    ArrayList<BurnFuelQueryResult> selectMaxId();

    ArrayList<BurnFuelQueryResult> selectAllElement(BurnFuelQueryParam params);

    ArrayList<BurnFuelQueryResult> GetElementInfo(BurnFuelQueryParam params);

    void UpdateElement(BurnFuelQueryParam params);

    void DeleteElement(BurnFuelQueryParam params);
}
