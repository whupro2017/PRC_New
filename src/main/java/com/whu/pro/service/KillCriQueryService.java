package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillCriQueryParam;
import com.whu.pro.mapper.result.KillCriQueryResult;

public interface KillCriQueryService {

    void InsertElement(KillCriQueryParam params);

    ArrayList<KillCriQueryResult> selectMaxId();
}
