/**
 * 
 */
package com.whu.pro.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.PointInfoQueryDao;
import com.whu.pro.mapper.param.InfoQueryParam;
import com.whu.pro.mapper.param.InfoTimeRangeQueryParam;
import com.whu.pro.mapper.result.InfoResult;
import com.whu.pro.service.PointInfoQueryService;

/**
 * @author Michael
 *
 */
@Service("PointInfoQueryService")
public class PointInfoQueryImpl implements PointInfoQueryService {
    @Resource
    PointInfoQueryDao piq;

    public InfoResult getPointInfoById(InfoQueryParam query) {
        return piq.getPointInfoById(query);
    }

    public List<InfoResult> getPointInfo(InfoQueryParam query) {
        return piq.getPointInfo(query);
    }

    public List<InfoResult> getPointTimeRangeInfo(InfoTimeRangeQueryParam query) {
        return piq.getPointTimeRangeInfo(query);
    }
}
