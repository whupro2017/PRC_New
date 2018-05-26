package com.whu.pro.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.PointsDao;
import com.whu.pro.mapper.param.PointsParam;
import com.whu.pro.mapper.param.PointsParam1;
import com.whu.pro.mapper.result.PointResult;
import com.whu.pro.service.PointsService;

@Service("PointsService")
public class PointsImpl implements PointsService {
    @Resource
    PointsDao pd;

    public ArrayList<PointResult> getAllPoints(PointsParam params) {
        // TODO Auto-generated method stub
        ArrayList<PointResult> list = pd.selectAllPoints(params);
        return list;
    }

    public ArrayList<PointResult> getAllPoints1(PointsParam1 params) {
        // TODO Auto-generated method stub
        ArrayList<PointResult> list = pd.selectAllPoints1(params);
        return list;
    }

    public ArrayList<PointResult> getAllColorPoints(PointsParam params) {
        // TODO Auto-generated method stub
        ArrayList<PointResult> list = pd.selectAllColorPoints(params);
        return list;
    }

    public ArrayList<PointResult> getAllColorPoints1(PointsParam1 params) {
        // TODO Auto-generated method stub
        ArrayList<PointResult> list = pd.selectAllColorPoints1(params);
        return list;
    }

    public Integer getCountColorPoints(PointsParam params) {
        // TODO Auto-generated method stub
        int num = 0;
        if (null != pd.selectCountColorPoints(params)) {
            num = pd.selectCountColorPoints(params);
        }
        return num;
    }

    public Integer getCountColorPoints1(PointsParam1 params) {
        // TODO Auto-generated method stub
        int num = 0;
        if (null != pd.selectCountColorPoints1(params)) {
            num = pd.selectCountColorPoints1(params);
        }
        return num;
    }
}
