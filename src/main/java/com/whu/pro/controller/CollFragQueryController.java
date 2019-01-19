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
import com.whu.pro.mapper.param.CollFragQueryParam;
import com.whu.pro.mapper.param.ConnectionQueryParam;
import com.whu.pro.mapper.result.CollFragQueryResult;
import com.whu.pro.service.CaseQueryService;
import com.whu.pro.service.CollFragQueryService;
import com.whu.pro.service.ConnectionQueryService;
import com.whu.pro.utils.FtpUtils;

@Controller
@RequestMapping("CollFragQueryController")
public class CollFragQueryController {
    private int type_id = 7003000;
    @Resource
    private CollFragQueryService CollFragqueryService;
    @Resource
    private ConnectionQueryService ConnectionQueryService;
    @Resource
    private CaseQueryService CasequeryService;
    
    @ResponseBody
    @RequestMapping(value = "InsertElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void InsertElement(HttpServletRequest request, HttpServletResponse response) throws Exception { //����Ҫ��id��ѯҪ�ر���Ҫ����Ϣ����ǰ̨��ʾ
        CollFragQueryParam cfqp = new CollFragQueryParam();
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
            System.out.println("δ¼��ģ���ļ�");
        } else {
            localname = FtpServerController.StoreModelFile(multipartFile);
        }
        cfqp.setBegin_date(create_date);
        cfqp.setElement_image(element_image);
        cfqp.setManager(manager);
        cfqp.setRemark(remark);
        cfqp.setLocalname(localname);
        CollFragqueryService.InsertElement(cfqp);
        if (case_id != "") {
            System.out.println("---------------- ��ʼ���������");
            ArrayList<CollFragQueryResult> list = CollFragqueryService.selectMaxId();
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

    @ResponseBody
    @RequestMapping(value = "UpdateElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void UpdateElement(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CollFragQueryParam cfqp = new CollFragQueryParam();
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
            System.out.println("ģ���ļ�δ����");
        } else {
            System.out.println("ģ���ļ�����");
            String localpath = localname.substring(0, localname.lastIndexOf("/"));
            String file_name = localname.substring(localname.lastIndexOf("/") + 1, localname.length());
            System.out.println("---------------- " + file_name);
            FtpUtils ftputils = new FtpUtils();
            ftputils.deleteFile(localpath, file_name);
            System.out.println("ɾ��ԭģ���ļ��ɹ�");
            localname = FtpServerController.StoreModelFile(multipartFile);
            System.out.println("����ģ���ļ��ɹ�");
        }
        cfqp.setElement_id(Integer.parseInt(element_id));
        cfqp.setManager(manager);
        cfqp.setRemark(remark);
        cfqp.setElement_image(temp);
        cfqp.setBegin_date(create_date);
        cfqp.setLocalname(localname);
        CollFragqueryService.UpdateElement(cfqp);
    }

    @ResponseBody
    @RequestMapping(value = "selectAllElement", method = { RequestMethod.GET, RequestMethod.POST })
    public Object selectAllElement(String begin_date, String end_date, String key_word) {
        if (begin_date.equals("")) {
            begin_date = "0000-00-00";
        }
        if (end_date.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
            end_date = df.format(new Date());
        }
        if (key_word.equals("")) {
            key_word = "ȫ��";
        }

        CollFragQueryParam cfqp = new CollFragQueryParam();
        cfqp.setKey_word(key_word);
        cfqp.setBegin_date(begin_date);
        cfqp.setEnd_date(end_date);
        ArrayList<CollFragQueryResult> list = CollFragqueryService.selectAllElement(cfqp);
        //ArrayList<ResultForShowImage> list1 = bytesImageToStringImage(list);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "GetElementInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public void GetElementInfo(HttpServletRequest request, HttpServletResponse response) throws IOException { //����Ҫ��id��ѯҪ�ر���Ҫ����Ϣ����ǰ̨��ʾ
        CollFragQueryParam cfqp = new CollFragQueryParam();
        int element_id = Integer.parseInt(request.getParameter("elementid"));
        cfqp.setElement_id(element_id);
        ArrayList<CollFragQueryResult> list = CollFragqueryService.GetElementInfo(cfqp);
        String element_manager = list.get(0).getElement_manager();
        String element_remark = list.get(0).getElement_remark();
        String create_date = list.get(0).getCreate_date();
        LinkedHashMap<String, String> map = new LinkedHashMap<>(); //ʹ��linkedhashmap����Map���Զ�����˳��
        map.put("Ҫ�ر��    ", element_id + "");
        map.put("���������� ", element_manager);
        map.put("����ʱ��    ", create_date);
        map.put("������ע    ", element_remark);
        String jsonMap = JSON.toJSONString(map, true);
        response.setCharacterEncoding("utf-8"); //���ñ���ģʽ���ǰ̨JSON������ʾ����
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(jsonMap);
        writer.flush();
        writer.close();
    }

    @ResponseBody
    @RequestMapping(value = "DeleteElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void DeleteElement(String element_id, String type_id) throws Exception {
        CollFragQueryParam cfqp = new CollFragQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        //byte[] bytes = element_image.getBytes();
        cfqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setType_id(Integer.parseInt(type_id));
        ArrayList<CollFragQueryResult> list = CollFragqueryService.GetElementInfo(cfqp);
        //ɾ��FTP��������ԭͼ
        String localname = list.get(0).getLocalname();
        if (localname.length()== 0) {
            System.out.println("δ�洢ģ���ļ�");
        } else {
            System.out.println("-------------------------localname" + localname);
            String localpath = localname.substring(0, localname.lastIndexOf("/"));
            String file_name = localname.substring(localname.lastIndexOf("/") + 1, localname.length());
            System.out.println("---------------- " + file_name);
            FtpUtils ftputils = new FtpUtils();
            ftputils.deleteFile(localpath, file_name);
            System.out.println("---------------- ɾ��ģ���ļ��ɹ�");
            //ɾ�����ݿ��¼
        }
        CollFragqueryService.DeleteElement(cfqp);
        System.out.println("---------------- ɾ��Ҫ�ر��¼�ɹ�");
        //ɾ���������¼
        ConnectionQueryService.DeleteConnection(ciqp);
        System.out.println("---------------- ɾ���������¼�ɹ�");
    }
}
