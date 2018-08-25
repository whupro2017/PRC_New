/**
 * 
 */
package com.whu.pro.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whu.pro.mapper.param.InfoQueryParam;
import com.whu.pro.mapper.param.InfoTimeRangeQueryParam;
import com.whu.pro.mapper.result.InfoResult;
import com.whu.pro.service.ModelInfoQueryService;

/**
 * @author Michael
 *
 */

@Controller
@RequestMapping("ModelInfoQueryController")
public class ModelInfoQueryController {
    @Resource
    private ModelInfoQueryService cqs;

    @ResponseBody
    @RequestMapping(value = "getModelInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getModelInfo(String begin, String end, double px, double py) {
        System.out.println(begin + ", " + end + ", " + px + ", " + py);
        List<InfoResult> results = null;
        try {
            Timestamp beginTime = new Timestamp(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH)
                    .parse("2000-01-01 00:00:00.000").getTime());
            Timestamp endTime = new Timestamp(System.currentTimeMillis());
            if (begin != null) {
                beginTime = new Timestamp(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH)
                        .parse(begin + " 00:00:00.000").getTime());

            }
            if (end != null) {
                endTime = new Timestamp(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH)
                        .parse(end + " 00:00:00.000").getTime());
            }
            InfoQueryParam ciqp = new InfoQueryParam();
            ciqp.setCenterx(px);
            ciqp.setCentery(py);
            ciqp.setCenterz(-1);
            ciqp.setBeginTime(beginTime);
            ciqp.setEndTime(endTime);
            results = cqs.getModelInfo(ciqp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return results;
    }

    @ResponseBody
    @RequestMapping(value = "getModelTimeRangeInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getModelTimeRangeInfo(String begin, String end) {
        System.out.println(begin + ", " + end);
        List<InfoResult> results = null;
        try {
            Timestamp beginTime = new Timestamp(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH)
                    .parse("2000-01-01 00:00:00.000").getTime());
            Timestamp endTime = new Timestamp(System.currentTimeMillis());
            if (begin != null) {
                beginTime = new Timestamp(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH)
                        .parse(begin + " 00:00:00.000").getTime());

            }
            if (end != null) {
                endTime = new Timestamp(new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH)
                        .parse(end + " 00:00:00.000").getTime());
            }
            InfoTimeRangeQueryParam ciqp = new InfoTimeRangeQueryParam();
            ciqp.setBeginTime(beginTime);
            ciqp.setEndTime(endTime);
            results = cqs.getModelTimeRangeInfo(ciqp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return results;
    }
}
