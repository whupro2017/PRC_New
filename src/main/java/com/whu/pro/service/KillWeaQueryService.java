package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.KillWeaQueryParam;
import com.whu.pro.mapper.result.KillWeaQueryResult;

public interface KillWeaQueryService {

    void InsertElement(KillWeaQueryParam params);

    ArrayList<KillWeaQueryResult> selectMaxId();

    ArrayList<KillWeaQueryResult> selectAllElement(KillWeaQueryParam params);

    ArrayList<KillWeaQueryResult> GetElementInfo(KillWeaQueryParam params);

    void UpdateElement(KillWeaQueryParam params);

    void DeleteElement(KillWeaQueryParam params);
}
