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
import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.param.MatInqQueryParam;
import com.whu.pro.mapper.result.MatInqQueryResult;
import com.whu.pro.service.CaseQueryService;
import com.whu.pro.service.ConnectionQueryService;
import com.whu.pro.service.MatInqQueryService;
import com.whu.pro.utils.FtpUtils;

@Controller
@RequestMapping("MatInqQueryController")
public class MatInqQueryController {
    private int type_id = 3001000;
    @Resource
    private MatInqQueryService MatInqqueryService;
    @Resource
    private ConnectionQueryService ConnectionQueryService;
    @Resource
    private CaseQueryService CasequeryService;
    
    @ResponseBody
    @RequestMapping(value = "InsertElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void InsertElement(String case_id, String manager, String remark, String element_image,
            String create_date, String localname)
            throws Exception {
        System.out.println("---------------- 开始插入要素表");
        MatInqQueryParam tcqp = new MatInqQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        //byte[] bytes = element_image.getBytes();
        String temp = element_image.replace(" ", "+"); //      客户端上传dataurl形式图片时链接中“+”被转换为“ ”，存入数据库之前转换回来
        System.out.println("---------------- 压缩图片字符串长度" + temp.length());
        tcqp.setManager(manager);
        tcqp.setRemark(remark);
        tcqp.setElement_image(temp);
        tcqp.setBegin_date(create_date);
        tcqp.setLocalname(localname);
        MatInqqueryService.InsertElement(tcqp);
        if (case_id != "") {
            System.out.println("---------------- 开始插入关联表");
            ArrayList<MatInqQueryResult> list = MatInqqueryService.selectMaxId();
            int element_id = list.get(0).getelement_id(); //存入关联表
            ciqp.setCase_id(Integer.parseInt(case_id));
            ciqp.setElement_id(element_id);
            ciqp.setType_id(type_id);
            ConnectionQueryService.InsertConnection(ciqp);
        }
    }

    @ResponseBody
    @RequestMapping(value = "UpdateElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void UpdateElement(String element_id, String manager, String remark, String element_image,
            String create_date, String localname)
            throws Exception {
        MatInqQueryParam tcqp = new MatInqQueryParam();
        //byte[] bytes = element_image.getBytes();
        String temp = element_image.replace(" ", "+"); //      客户端上传dataurl形式图片时链接中“+”被转换为“ ”，存入数据库之前转换回来
        System.out.println("---------------- 压缩图片长度" + temp.length());
        tcqp.setElement_id(Integer.parseInt(element_id));
        tcqp.setManager(manager);
        tcqp.setRemark(remark);
        tcqp.setElement_image(temp);
        tcqp.setBegin_date(create_date);
        tcqp.setLocalname(localname);
        MatInqqueryService.UpdateElement(tcqp);
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

        MatInqQueryParam miqp = new MatInqQueryParam();

        miqp.setKey_word(key_word);
        miqp.setBegin_date(begin_date);
        miqp.setEnd_date(end_date);
        ArrayList<MatInqQueryResult> list = MatInqqueryService.selectAllElement(miqp);
        //ArrayList<ResultForShowImage> list1 = bytesImageToStringImage(list);
        return list;
    }
   
    @ResponseBody
    @RequestMapping(value = "GetElementInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public void GetElementInfo(HttpServletRequest request, HttpServletResponse response) throws IOException { //根据要素id查询要素表获得要素信息返回前台显示
        MatInqQueryParam tcqp = new MatInqQueryParam();
        int element_id = Integer.parseInt(request.getParameter("elementid"));
        tcqp.setElement_id(element_id);
        ArrayList<MatInqQueryResult> list = MatInqqueryService.GetElementInfo(tcqp);
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
    }

    @ResponseBody
    @RequestMapping(value = "DeleteElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void DeleteElement(String element_id, String type_id) throws Exception {
        System.out.println("---------------- ");
        MatInqQueryParam miqp = new MatInqQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        //byte[] bytes = element_image.getBytes();
        miqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setType_id(Integer.parseInt(type_id));
        ArrayList<MatInqQueryResult> list = MatInqqueryService.GetElementInfo(miqp);
        //删除FTP服务器上原图
        String localname = list.get(0).getLocalname();
        String localpath = localname.substring(0, localname.lastIndexOf("/"));
        String file_name = localname.substring(localname.lastIndexOf("/") + 1, localname.length());
        System.out.println("---------------- " + file_name);
        FtpUtils ftputils = new FtpUtils();
        ftputils.deleteFile(localpath, file_name);
        System.out.println("---------------- 删除原始文件成功");
        //删除数据库记录
        MatInqqueryService.DeleteElement(miqp);
        System.out.println("---------------- 删除要素表记录成功");
        //删除关联表记录
        ConnectionQueryService.DeleteConnection(ciqp);
        System.out.println("---------------- 删除关联表记录成功");

    }
}
