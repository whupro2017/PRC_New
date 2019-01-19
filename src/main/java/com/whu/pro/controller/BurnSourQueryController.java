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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.whu.pro.mapper.param.BurnSourQueryParam;
import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.result.BurnSourQueryResult;
import com.whu.pro.service.BurnSourQueryService;
import com.whu.pro.service.CaseQueryService;
import com.whu.pro.service.ConnectionQueryService;
import com.whu.pro.utils.FtpUtils;

@Controller
@RequestMapping("BurnSourQueryController")
public class BurnSourQueryController {
    private int type_id = 4001000;
    @Resource
    private BurnSourQueryService BurnSourqueryService;
    @Resource
    private ConnectionQueryService ConnectionQueryService;
    @Resource
    private CaseQueryService CasequeryService;
    
    @ResponseBody
    @RequestMapping(value = "InsertElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void InsertElement(HttpServletRequest request, HttpServletResponse response) throws Exception { //根据要素id查询要素表获得要素信息返回前台显示
        BurnSourQueryParam bsqp = new BurnSourQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        String case_id = request.getParameter("case_id");
        String manager = request.getParameter("manager");
        String remark = request.getParameter("remark");
        String element_image = request.getParameter("element_image");
        String temp = element_image.replace(" ", "+");
        String create_date = request.getParameter("create_date");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        String localname = "";
        if (multipartFile == null) {
            System.out.println("未录入模型文件");
        } else {
            localname = FtpServerController.StoreModelFile(multipartFile);
        }
        bsqp.setBegin_date(create_date);
        bsqp.setElement_image(element_image);
        bsqp.setManager(manager);
        bsqp.setRemark(remark);
        bsqp.setLocalname(localname);
        BurnSourqueryService.InsertElement(bsqp);
        if (case_id != "") {
            System.out.println("---------------- 开始插入关联表");
            ArrayList<BurnSourQueryResult> list = BurnSourqueryService.selectMaxId();
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

    @ResponseBody
    @RequestMapping(value = "UpdateElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void UpdateElement(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BurnSourQueryParam bsqp = new BurnSourQueryParam();
        String element_id = request.getParameter("element_id");
        String manager = request.getParameter("manager");
        String remark = request.getParameter("remark");
        String element_image = request.getParameter("element_image");
        String temp = element_image.replace(" ", "+");
        String create_date = request.getParameter("create_date");
        String localname = request.getParameter("localname");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        if (multipartFile == null) {
            System.out.println("模型文件未更新");
        } else {
            System.out.println("模型文件更新");
            String localpath = localname.substring(0, localname.lastIndexOf("/"));
            String file_name = localname.substring(localname.lastIndexOf("/") + 1, localname.length());
            System.out.println("---------------- " + file_name);
            FtpUtils ftputils = new FtpUtils();
            ftputils.deleteFile(localpath, file_name);
            System.out.println("删除原模型文件成功");
            localname = FtpServerController.StoreModelFile(multipartFile);
            System.out.println("更新模型文件成功");
        }
        bsqp.setElement_id(Integer.parseInt(element_id));
        bsqp.setManager(manager);
        bsqp.setRemark(remark);
        bsqp.setElement_image(temp);
        bsqp.setBegin_date(create_date);
        bsqp.setLocalname(localname);
        BurnSourqueryService.UpdateElement(bsqp);
    }

    @ResponseBody
    @RequestMapping(value = "selectAllElement", method = { RequestMethod.GET, RequestMethod.POST })
    public Object selectAllElement(String begin_date, String end_date, String key_word) {
        if (begin_date.equals("")) {
            begin_date = "0000-00-00";
        }
        if (end_date.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            end_date = df.format(new Date());
        }
        if (key_word.equals("")) {
            key_word = "全部";
        }

        BurnSourQueryParam bsqp = new BurnSourQueryParam();
        bsqp.setKey_word(key_word);
        bsqp.setBegin_date(begin_date);
        bsqp.setEnd_date(end_date);
        ArrayList<BurnSourQueryResult> list = BurnSourqueryService.selectAllElement(bsqp);
        //ArrayList<ResultForShowImage> list1 = bytesImageToStringImage(list);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "GetElementInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public void GetElementInfo(HttpServletRequest request, HttpServletResponse response) throws IOException { //根据要素id查询要素表获得要素信息返回前台显示
        BurnSourQueryParam bsqp = new BurnSourQueryParam();
        int element_id = Integer.parseInt(request.getParameter("elementid"));
        bsqp.setElement_id(element_id);
        ArrayList<BurnSourQueryResult> list = BurnSourqueryService.GetElementInfo(bsqp);
        String element_manager = list.get(0).getElement_manager();
        String element_remark = list.get(0).getElement_remark();
        String create_date = list.get(0).getCreate_date();
        LinkedHashMap<String, String> map = new LinkedHashMap<>(); //使用linkedhashmap避免Map中自动调整顺序
        map.put("要素编号    ", element_id + "");
        map.put("案件负责人 ", element_manager);
        map.put("创建时间    ", create_date);
        map.put("案件备注    ", element_remark);
        String jsonMap = JSON.toJSONString(map, true);
        response.setCharacterEncoding("utf-8"); //设置编码模式解决前台JSON中文显示问题
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonMap);
        writer.flush();
        writer.close();
        ListNode
    }

    @ResponseBody
    @RequestMapping(value = "DeleteElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void DeleteElement(String element_id, String type_id) throws Exception {
        BurnSourQueryParam bsqp = new BurnSourQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        //byte[] bytes = element_image.getBytes();
        bsqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setType_id(Integer.parseInt(type_id));
        ArrayList<BurnSourQueryResult> list = BurnSourqueryService.GetElementInfo(bsqp);
        //删除FTP服务器上原图
        String localname = list.get(0).getLocalname();
        if (localname.length()== 0) {
            System.out.println("未存储模型文件");
        } else {
            System.out.println("-------------------------localname" + localname);
            String localpath = localname.substring(0, localname.lastIndexOf("/"));
            String file_name = localname.substring(localname.lastIndexOf("/") + 1, localname.length());
            System.out.println("---------------- " + file_name);
            FtpUtils ftputils = new FtpUtils();
            ftputils.deleteFile(localpath, file_name);
            System.out.println("---------------- 删除模型文件成功");
            //删除数据库记录
        }
        BurnSourqueryService.DeleteElement(bsqp);
        System.out.println("---------------- 删除要素表记录成功");
        //删除关联表记录
        ConnectionQueryService.DeleteConnection(ciqp);
        System.out.println("---------------- 删除关联表记录成功");
    }
}
