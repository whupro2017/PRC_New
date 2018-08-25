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
public interface ModelInfoQueryDao {
    List<InfoResult> getModelInfo(InfoQueryParam query);

    List<InfoResult> getModelTimeRangeInfo(InfoTimeRangeQueryParam query);
}
