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
import com.whu.pro.mapper.param.MatFingQueryParam;
import com.whu.pro.mapper.result.MatFingQueryResult;
import com.whu.pro.service.CaseQueryService;
import com.whu.pro.service.ConnectionQueryService;
import com.whu.pro.service.MatFingQueryService;
import com.whu.pro.utils.FtpUtils;

@Controller
@RequestMapping("MatFingQueryController")
public class MatFingQueryController {
    private int type_id = 3004000;
    @Resource
    private MatFingQueryService MatFingqueryService;
    @Resource
    private ConnectionQueryService ConnectionQueryService;
    @Resource
    private CaseQueryService CasequeryService;
    

    @ResponseBody
    @RequestMapping(value = "InsertElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void InsertElement(String case_id, String manager, String remark, String element_image,
            String create_date, String localname) throws Exception {
        System.out.println("----------------到128行 开始插入要素表");
        MatFingQueryParam mfpqp = new MatFingQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        //byte[] bytes = element_image.getBytes();
        String temp = element_image.replace(" ", "+"); //      客户端上传dataurl形式图片时链接中“+”被转换为“ ”，存入数据库之前转换回来
        System.out.println("----------------到133行 压缩图片字符串长度" + temp.length());
        mfpqp.setManager(manager);
        mfpqp.setRemark(remark);
        mfpqp.setElement_image(temp);
        mfpqp.setBegin_date(create_date);
        mfpqp.setLocalname(localname);
        MatFingqueryService.InsertElement(mfpqp);
        if (case_id != "") {
            System.out.println("----------------到128行 开始插入关联表");
            ArrayList<MatFingQueryResult> list = MatFingqueryService.selectMaxId();
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
            String create_date, String localname) throws Exception {
        MatFingQueryParam mfpqp = new MatFingQueryParam();
        //byte[] bytes = element_image.getBytes();
        String temp = element_image.replace(" ", "+"); //      客户端上传dataurl形式图片时链接中“+”被转换为“ ”，存入数据库之前转换回来
        System.out.println("---------------- 压缩图片长度" + temp.length());
        mfpqp.setElement_id(Integer.parseInt(element_id));
        mfpqp.setManager(manager);
        mfpqp.setRemark(remark);
        mfpqp.setElement_image(temp);
        mfpqp.setBegin_date(create_date);
        mfpqp.setLocalname(localname);
        MatFingqueryService.UpdateElement(mfpqp);
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

        MatFingQueryParam mfpqp = new MatFingQueryParam();

        mfpqp.setKey_word(key_word);
        mfpqp.setBegin_date(begin_date);
        mfpqp.setEnd_date(end_date);
        ArrayList<MatFingQueryResult> list = MatFingqueryService.selectAllElement(mfpqp);
        //ArrayList<ResultForShowImage> list1 = bytesImageToStringImage(list);
        return list;
    }
   
    @ResponseBody
    @RequestMapping(value = "GetElementInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public void GetElementInfo(HttpServletRequest request, HttpServletResponse response) throws IOException { //根据要素id查询要素表获得要素信息返回前台显示
        MatFingQueryParam mfpqp = new MatFingQueryParam();
        int element_id = Integer.parseInt(request.getParameter("elementid"));
        mfpqp.setElement_id(element_id);
        ArrayList<MatFingQueryResult> list = MatFingqueryService.GetElementInfo(mfpqp);
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
        MatFingQueryParam mfpqp = new MatFingQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        //byte[] bytes = element_image.getBytes();
        mfpqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setType_id(Integer.parseInt(type_id));
        ArrayList<MatFingQueryResult> list = MatFingqueryService.GetElementInfo(mfpqp);
        //删除FTP服务器上原图
        String localname = list.get(0).getLocalname();
        String localpath = localname.substring(0, localname.lastIndexOf("/"));
        String file_name = localname.substring(localname.lastIndexOf("/") + 1, localname.length());
        System.out.println("---------------- " + file_name);
        FtpUtils ftputils = new FtpUtils();
        ftputils.deleteFile(localpath, file_name);
        System.out.println("---------------- 删除原始文件成功");
        //删除数据库记录
        MatFingqueryService.DeleteElement(mfpqp);
        System.out.println("---------------- 删除要素表记录成功");
        //删除关联表记录
        ConnectionQueryService.DeleteConnection(ciqp);
        System.out.println("---------------- 删除关联表记录成功");
    }
}


