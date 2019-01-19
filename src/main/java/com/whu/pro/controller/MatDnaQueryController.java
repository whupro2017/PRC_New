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
import com.whu.pro.mapper.param.MatDnaQueryParam;
import com.whu.pro.mapper.result.MatDnaQueryResult;
import com.whu.pro.service.CaseQueryService;
import com.whu.pro.service.ConnectionQueryService;
import com.whu.pro.service.MatDnaQueryService;
import com.whu.pro.utils.FtpUtils;

@Controller
@RequestMapping("MatDnaQueryController")
public class MatDnaQueryController {
    private int type_id = 3006000;
    @Resource
    private MatDnaQueryService MatDnaqueryService;
    @Resource
    private ConnectionQueryService ConnectionQueryService;
    @Resource
    private CaseQueryService CasequeryService;

    @ResponseBody
    @RequestMapping(value = "InsertElement", method = { RequestMethod.GET, RequestMethod.POST })
    public void InsertElement(String case_id, String manager, String remark, String element_image,
            String create_date, String localname) throws Exception {
        System.out.println("----------------��128�� ��ʼ����Ҫ�ر�");
        MatDnaQueryParam mdqp = new MatDnaQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        //byte[] bytes = element_image.getBytes();
        String temp = element_image.replace(" ", "+"); //      �ͻ����ϴ�dataurl��ʽͼƬʱ�����С�+����ת��Ϊ�� �����������ݿ�֮ǰת������
        System.out.println("----------------��133�� ѹ��ͼƬ�ַ�������" + temp.length());
        mdqp.setManager(manager);
        mdqp.setRemark(remark);
        mdqp.setElement_image(temp);
        mdqp.setBegin_date(create_date);
        mdqp.setLocalname(localname);
        MatDnaqueryService.InsertElement(mdqp);
        if (case_id != "") {
            System.out.println("----------------��128�� ��ʼ���������");
            ArrayList<MatDnaQueryResult> list = MatDnaqueryService.selectMaxId();
            int element_id = list.get(0).getelement_id(); //���������
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
        MatDnaQueryParam mdqp = new MatDnaQueryParam();
        //byte[] bytes = element_image.getBytes();
        String temp = element_image.replace(" ", "+"); //      �ͻ����ϴ�dataurl��ʽͼƬʱ�����С�+����ת��Ϊ�� �����������ݿ�֮ǰת������
        System.out.println("---------------- ѹ��ͼƬ����" + temp.length());
        mdqp.setElement_id(Integer.parseInt(element_id));
        mdqp.setManager(manager);
        mdqp.setRemark(remark);
        mdqp.setElement_image(temp);
        mdqp.setBegin_date(create_date);
        mdqp.setLocalname(localname);
        MatDnaqueryService.UpdateElement(mdqp);
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

        MatDnaQueryParam mdqp = new MatDnaQueryParam();

        mdqp.setKey_word(key_word);
        mdqp.setBegin_date(begin_date);
        mdqp.setEnd_date(end_date);
        ArrayList<MatDnaQueryResult> list = MatDnaqueryService.selectAllElement(mdqp);
        //ArrayList<ResultForShowImage> list1 = bytesImageToStringImage(list);
        return list;
    }
   
    @ResponseBody
    @RequestMapping(value = "GetElementInfo", method = { RequestMethod.GET, RequestMethod.POST })
    public void GetElementInfo(HttpServletRequest request, HttpServletResponse response) throws IOException { //����Ҫ��id��ѯҪ�ر���Ҫ����Ϣ����ǰ̨��ʾ
        MatDnaQueryParam mdqp = new MatDnaQueryParam();
        int element_id = Integer.parseInt(request.getParameter("elementid"));
        mdqp.setElement_id(element_id);
        ArrayList<MatDnaQueryResult> list = MatDnaqueryService.GetElementInfo(mdqp);
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
        System.out.println("---------------- ");
        MatDnaQueryParam mdqp = new MatDnaQueryParam();
        ConnectionQueryParam ciqp = new ConnectionQueryParam();
        //byte[] bytes = element_image.getBytes();
        mdqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setElement_id(Integer.parseInt(element_id));
        ciqp.setType_id(Integer.parseInt(type_id));
        ArrayList<MatDnaQueryResult> list = MatDnaqueryService.GetElementInfo(mdqp);
        //ɾ��FTP��������ԭͼ
        String localname = list.get(0).getLocalname();
        String localpath = localname.substring(0, localname.lastIndexOf("/"));
        String file_name = localname.substring(localname.lastIndexOf("/") + 1, localname.length());
        System.out.println("---------------- " + file_name);
        FtpUtils ftputils = new FtpUtils();
        ftputils.deleteFile(localpath, file_name);
        System.out.println("---------------- ɾ��ԭʼ�ļ��ɹ�");
        //ɾ�����ݿ��¼
        MatDnaqueryService.DeleteElement(mdqp);
        System.out.println("---------------- ɾ��Ҫ�ر��¼�ɹ�");
        //ɾ���������¼
        ConnectionQueryService.DeleteConnection(ciqp);
        System.out.println("---------------- ɾ���������¼�ɹ�");
    }
}