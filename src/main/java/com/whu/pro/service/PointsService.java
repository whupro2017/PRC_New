package com.whu.pro.service;

import java.util.ArrayList;

import com.whu.pro.mapper.param.PointsParam;
import com.whu.pro.mapper.param.PointsParam1;
import com.whu.pro.mapper.result.PointResult;

public interface PointsService {
    ArrayList<PointResult> getAllPoints(PointsParam params);

    ArrayList<PointResult> getAllPoints1(PointsParam1 params);

    ArrayList<PointResult> getAllColorPoints(PointsParam params);

    ArrayList<PointResult> getAllColorPoints1(PointsParam1 params);
}
