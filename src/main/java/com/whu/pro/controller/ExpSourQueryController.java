package com.whu.pro.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.param.ExpSourQueryParam;
import com.whu.pro.mapper.result.ExpSourQueryResult;
import com.whu.pro.service.CaseQueryService;
import com.whu.pro.service.ConnectionQueryService;
import com.whu.pro.service.ExpSourQueryService;

@Controller
@RequestMapping("ExpSourQueryController")
public class ExpSourQueryController {
    private int type_id = 5002000;
    @Resource
    private ExpSourQueryService ExpSourqueryService;
    @Resource
    private ConnectionQueryService ConnectionQueryService;
    @Resource
    private CaseQueryService CasequeryService;
    
    @ResponseBody
    @RequestMapping(value = "InsertElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void InsertElement(HttpServletRequest request, HttpServletResponse response) throws Exception { //根据要素id查询要素表获得要素信息返回前台显示
        ExpSourQueryParam esqp = new ExpSourQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        String case_id = request.getParameter("case_id");
        String manager = request.getParameter("manager");
        String remark = request.getParameter("remark");
        String element_image = request.getParameter("element_image");
        String temp = element_image.replace(" ", "+");
        String create_date = request.getParameter("create_date");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        String localname = FtpServerController.StoreModelFile(multipartFile);
        esqp.setBegin_date(create_date);
        esqp.setElement_image(element_image);
        esqp.setManager(manager);
        esqp.setRemark(remark);
        esqp.setLocalname(localname);
        ExpSourqueryService.InsertElement(esqp);
        if (case_id != "") {
            System.out.println("---------------- 开始插入关联表");
            ArrayList<ExpSourQueryResult> list = ExpSourqueryService.selectMaxId();
            int element_id;
            if(list.size()==0) {
                element_id = 1;
            }else {
                element_id = list.get(0).getelement_id(); //存入关联表
            }
            ciqp.setCase_id(Integer.parseInt(case_id));
            ciqp.setElement_id(element_id);
            ciqp.setType_id(type_id);
            ConnectionQueryService.InsertConnection(ciqp);
        }
    }
}
