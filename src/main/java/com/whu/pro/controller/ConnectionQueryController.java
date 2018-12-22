package com.whu.pro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.result.ConnectionQueryResult;
import com.whu.pro.service.ConnectionQueryService;

@Controller
@RequestMapping("ConnectionQueryController")
public class ConnectionQueryController {
    @Resource
    private ConnectionQueryService ConnectionQueryService;

    @ResponseBody
    @RequestMapping(value = "InsertConnection", method = { RequestMethod.GET, RequestMethod.POST })
    public void InsertConnection(String case_id, String element_id, String type_id) throws Exception {
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        ciqp.setCase_id(Integer.parseInt(case_id));
        ciqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setType_id(Integer.parseInt(type_id));
        ConnectionQueryService.InsertConnection(ciqp);
    }

    @ResponseBody
    @RequestMapping(value = "GetElements", method = { RequestMethod.GET, RequestMethod.POST }) // 根据case_id及Controller对应type_id查询关联表获得各要素id
    public Object GetElements(String c_id, String t_id) throws IOException {
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        int case_id = Integer.parseInt(c_id);
        int type_id = Integer.parseInt(t_id);
        ciqp.setCase_id(case_id);
        ciqp.setType_id(type_id);
        ArrayList<ConnectionQueryResult> list = ConnectionQueryService.SeleConnections(ciqp);
        int length = list.size();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            map.put("element" + i, list.get(i).getElement_id());
        }
        map.put("length", length);
        String jsonMap = JSON.toJSONString(map, true);
        return jsonMap;
    }

    @ResponseBody
    @RequestMapping(value = "GetCases", method = { RequestMethod.GET, RequestMethod.POST }) // 根据case_id及Controller对应的type_id查询关联表获得各要素id
    public Object GetCases(String e_id, String t_id) throws IOException {
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        int element_id = Integer.parseInt(e_id);
        int type_id = Integer.parseInt(t_id);
        ciqp.setElement_id(element_id);
        ciqp.setType_id(type_id);
        ArrayList<ConnectionQueryResult> list = ConnectionQueryService.SeleConnections(ciqp);
        int length = list.size();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            map.put("case" + i, list.get(i).getCase_id());
        }
        map.put("length", length);
        String jsonMap = JSON.toJSONString(map, true);
        return jsonMap;
    }
}
