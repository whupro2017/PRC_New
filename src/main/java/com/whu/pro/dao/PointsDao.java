package com.whu.pro.dao;

import java.util.ArrayList;

import com.whu.pro.mapper.param.PointsParam;
import com.whu.pro.mapper.param.PointsParam1;
import com.whu.pro.mapper.result.PointResult;

public interface PointsDao {
    ArrayList<PointResult> selectAllPoints(PointsParam params);

    ArrayList<PointResult> selectAllPoints1(PointsParam1 params);

    ArrayList<PointResult> selectAllColorPoints(PointsParam params);

    ArrayList<PointResult> selectAllColorPoints1(PointsParam1 params);

    Integer selectCountColorPoints(PointsParam params);

    Integer selectCountColorPoints1(PointsParam1 params);
}
