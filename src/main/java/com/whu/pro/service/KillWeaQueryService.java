package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillWeaQueryParam;
import com.whu.pro.mapper.result.KillWeaQueryResult;

public interface KillWeaQueryService {

    void InsertElement(KillWeaQueryParam params);

    ArrayList<KillWeaQueryResult> selectMaxId();
}
