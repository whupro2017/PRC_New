package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.CollObjQueryParam;
import com.whu.pro.mapper.result.CollObjQueryResult;

public interface CollObjQueryService {

    void InsertElement(CollObjQueryParam params);

    ArrayList<CollObjQueryResult> selectMaxId();
}
