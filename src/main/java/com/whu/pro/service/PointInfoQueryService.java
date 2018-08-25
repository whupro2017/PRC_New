/**
 * 
 */
package com.whu.pro.service;

import java.util.List;

import com.whu.pro.mapper.param.InfoQueryParam;
import com.whu.pro.mapper.param.InfoTimeRangeQueryParam;
import com.whu.pro.mapper.result.InfoResult;

/**
 * @author Michael
 *
 */
public interface PointInfoQueryService {
    List<InfoResult> getPointInfo(InfoQueryParam query);

    List<InfoResult> getPointTimeRangeInfo(InfoTimeRangeQueryParam query);
}
