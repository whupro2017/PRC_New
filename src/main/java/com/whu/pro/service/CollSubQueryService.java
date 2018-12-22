package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CollSubQueryParam;
import com.whu.pro.mapper.result.CollSubQueryResult;

public interface CollSubQueryService {

    void InsertElement(CollSubQueryParam params);

    ArrayList<CollSubQueryResult> selectMaxId();
}
