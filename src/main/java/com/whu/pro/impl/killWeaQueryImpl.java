package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.KillWeaQueryDao;
import com.whu.pro.mapper.param.KillWeaQueryParam;
import com.whu.pro.mapper.result.KillWeaQueryResult;
import com.whu.pro.service.KillWeaQueryService;

@Service("KillWeaQueryService")
public class killWeaQueryImpl implements KillWeaQueryService {
    @Resource
    KillWeaQueryDao kwqd;
    
    public void InsertElement(KillWeaQueryParam params) {
        kwqd.InsertElement(params);
        // TODO Auto-generated method stub
    }
    
    public ArrayList<KillWeaQueryResult> selectMaxId() {
        ArrayList<KillWeaQueryResult> list = kwqd.selectMaxId();
        return list;
    }
}