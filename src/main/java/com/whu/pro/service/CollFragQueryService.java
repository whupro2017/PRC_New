package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CollFragQueryParam;
import com.whu.pro.mapper.result.CollFragQueryResult;

public interface CollFragQueryService {

    void InsertElement(CollFragQueryParam params);

    ArrayList<CollFragQueryResult> selectMaxId();
}
