/**
 * 
 */
package com.whu.pro.dao;

import java.util.List;

import com.whu.pro.mapper.param.InfoQueryParam;
import com.whu.pro.mapper.param.InfoTimeRangeQueryParam;
import com.whu.pro.mapper.result.InfoResult;

/**
 * @author Michael
 *
 */
public interface PointInfoQueryDao {
    InfoResult getPointInfoById(InfoQueryParam query);

    List<InfoResult> getPointInfo(InfoQueryParam query);

    List<InfoResult> getPointTimeRangeInfo(InfoTimeRangeQueryParam query);
}
