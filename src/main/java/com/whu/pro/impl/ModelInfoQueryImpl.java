/**
 * 
 */
package com.whu.pro.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whu.pro.dao.ModelInfoQueryDao;
import com.whu.pro.mapper.param.InfoQueryParam;
import com.whu.pro.mapper.param.InfoTimeRangeQueryParam;
import com.whu.pro.mapper.result.InfoResult;
import com.whu.pro.service.ModelInfoQueryService;

/**
 * @author Michael
 *
 */
@Service("ModelInfoQueryImpl")
public class ModelInfoQueryImpl implements ModelInfoQueryService {
    @Resource
    ModelInfoQueryDao piq;

    public List<InfoResult> getModelInfo(InfoQueryParam query) {
        return piq.getModelInfo(query);
    }

    public List<InfoResult> getModelTimeRangeInfo(InfoTimeRangeQueryParam query) {
        return piq.getModelTimeRangeInfo(query);
    }
}
