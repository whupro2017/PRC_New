package com.whu.pro.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.whu.pro.mapper.param.CaseQueryParam;
import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.result.CaseQueryResult;
import com.whu.pro.service.CaseQueryService;
import com.whu.pro.service.ConnectionQueryService;

@Controller
@RequestMapping("CaseQueryController")
public class CaseQueryController {
    @Resource
    private CaseQueryService casequeryService;
    @Resource
    private ConnectionQueryService ConnectionQueryService;

    @ResponseBody
    @RequestMapping(value = "getAllCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getAllCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getAllCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getAllCaseByKeyword", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getAllCaseByKeyword(String beginTime, String endTime, String keyword) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }
        if (keyword.equals("")) {
            keyword = "全部";
        }
        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setKeyword(keyword);
        ArrayList<CaseQueryResult> list = casequeryService.getAllCaseByKeyword(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }
    @ResponseBody
    @RequestMapping(value = "getBurnCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getBurnCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getBurnCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getBomCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getBomCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getBomCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getGrabCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getGrabCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getGrabCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getKillCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getKillCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getKillCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "GetElementInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public Object GetElementInfo(String id) {

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setId(Integer.parseInt(id));

        ArrayList<CaseQueryResult> list = casequeryService.GetCaseInfo(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "InsertCase", method = { RequestMethod.GET, RequestMethod.POST })
    public void InsertCase(String id, String beginTime, String pro, String city, String dis, String des, String type) {

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setId(Integer.parseInt(id));
        cqp.setBeginTime(beginTime);
        cqp.setCity(city);
        cqp.setPro(pro);
        cqp.setDes(des);
        cqp.setDis(dis);
        cqp.setType(type);
        casequeryService.InsertCase(cqp);
    }

    @ResponseBody
    @RequestMapping(value = "GetCaseInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public void GetCaseInfo(HttpServletRequest request, HttpServletResponse response) throws IOException { //根据案件id查询要素表获得案件信息返回前台显示
        CaseQueryParam cqp = new CaseQueryParam();
        int case_id = Integer.parseInt(request.getParameter("case_id"));
        cqp.setId(case_id);
        ArrayList<CaseQueryResult> list = casequeryService.GetCaseInfo(cqp);
        String case_time = list.get(0).getCase_time();
        String case_location = list.get(0).getCase_location();
        System.out.println("地点" + case_location);
        String case_desc = list.get(0).getCase_desc();
        LinkedHashMap<String, String> map = new LinkedHashMap<>(); //使用linkedhashmap避免Map中自动调整顺序
        map.put("案件编号    ", case_id + "");
        map.put("案件时间    ", case_time);
        map.put("案件地点    ", case_location);
        map.put("案件描述    ", case_desc);
        String jsonMap = JSON.toJSONString(map, true);
        response.setCharacterEncoding("utf-8"); //设置编码模式解决前台JSON中文显示问题
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonMap);
        writer.flush();
        writer.close();
    }

    @ResponseBody
    @RequestMapping(value = "DeleteCase", method = { RequestMethod.GET, RequestMethod.POST })
    public void DeleteElement(String case_id) throws Exception {
        System.out.println("---------------- 开始删除案件");
        CaseQueryParam cqp = new CaseQueryParam();
        ConnectionQueryParam cnqp = new ConnectionQueryParam();
        cqp.setId(Integer.parseInt(case_id));
        cnqp.setCase_id(Integer.parseInt(case_id));
        //删除数据库记录
        casequeryService.DeleteCase(cqp);
        System.out.println("---------------- 删除案件表记录成功");
        //删除关联表记录
        ConnectionQueryService.DeleteConnection(cnqp);
        System.out.println("---------------- 删除关联表记录成功");
    }
}
