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

import com.whu.pro.mapper.param.BurnResQueryParam;
import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.result.BurnResQueryResult;
import com.whu.pro.service.BurnResQueryService;
import com.whu.pro.service.CaseQueryService;
import com.whu.pro.service.ConnectionQueryService;

@Controller
@RequestMapping("BurnResQueryController")
public class BurnResQueryController {
    private int type_id = 4005000;
    @Resource
    private BurnResQueryService BurnResqueryService;
    @Resource
    private ConnectionQueryService ConnectionQueryService;
    @Resource
    private CaseQueryService CasequeryService;
    
    @ResponseBody
    @RequestMapping(value = "InsertElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void InsertElement(HttpServletRequest request, HttpServletResponse response) throws Exception { //����Ҫ��id��ѯҪ�ر����Ҫ����Ϣ����ǰ̨��ʾ
        BurnResQueryParam brqp = new BurnResQueryParam();
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
        brqp.setBegin_date(create_date);
        brqp.setElement_image(element_image);
        brqp.setManager(manager);
        brqp.setRemark(remark);
        brqp.setLocalname(localname);
        BurnResqueryService.InsertElement(brqp);
        if (case_id != "") {
            System.out.println("---------------- ��ʼ���������");
            ArrayList<BurnResQueryResult> list = BurnResqueryService.selectMaxId();
            int element_id;
            if(list.size()==0) {
                element_id = 1;
            }else {
                element_id = list.get(0).getelement_id(); //���������
            }
            ciqp.setCase_id(Integer.parseInt(case_id));
            ciqp.setElement_id(element_id);
            ciqp.setType_id(type_id);
            ConnectionQueryService.InsertConnection(ciqp);
        }
    }
}