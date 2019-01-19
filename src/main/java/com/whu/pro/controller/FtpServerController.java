package com.whu.pro.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.whu.pro.utils.FtpUtils;
import com.whu.pro.utils.GdalUtils;

@Controller
@RequestMapping("FtpServerController")
public class FtpServerController {
    @ResponseBody
    @RequestMapping(value = "StoreRawImage", method = { RequestMethod.GET, RequestMethod.POST })
    public void StoreRawImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;  
        MultipartFile multipartFile = multipartRequest.getFile("file");//file��form-data�ж������ֶζ�Ӧ��name
        String image_length = multipartRequest.getParameter("image_length");
        // String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());//����ȡ���ļ���׺
        String fileDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String original_name = multipartFile.getOriginalFilename();
        StringBuilder sb = new StringBuilder(original_name);//����һ��StringBuilder����
        sb.insert(original_name.indexOf("."), "at" + fileDate.substring(8, 14));//���ļ��������ʱ��HHmmss��������
        String name = sb.toString();//�õ������ļ���
        String filepath = "/images/RawImages/" + fileDate.substring(0, 4) + "/" + fileDate.substring(4, 6) + "-" //    FTP�������洢Ŀ¼��·��Ϊ/images/BigRawImages/xxxx���꣩/xx-xx����-�գ�/�ļ�
                + fileDate.substring(6, 8) + "/";

        FtpUtils ftputils = new FtpUtils();
        ftputils.uploadFile(filepath, name, multipartFile.getInputStream());//ԭʼͼƬ����FTP������

        // ����ͼƬ���ص�ַ��ǰ̨�������ݿ�
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        Map<String, String> map = new HashMap<>();
        String localname = filepath + name;
        map.put("localname", localname); //localname��������FTP���������ļ�
        String compressedBase64 = "";

        //��ͼƬ����1.5M,��ͼƬ�ݴ���FTP��������ȡ����ͼ������������ͼbase64�ַ�����ǰ̨
        if (Integer.parseInt(image_length) >= 1500000) {
            String tempImageName = UUID.randomUUID().toString() + ".jpg";// ��������ļ�����
            String compressedFileName = "E:/FTPServer" + filepath + tempImageName; //FTP����ʱ��ȡ�ļ�·��
            GdalUtils.CompressByGdal("E:/FTPServer" + localname, compressedFileName);

            //������ͼתΪbase64�ַ�������ǰ̨
            InputStream in = null;
            byte[] data = null;
            try { // ��ȡͼƬ�ֽ�����
                in = new FileInputStream(compressedFileName);

                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            compressedBase64 = "data:image/jpeg;base64," + Base64.encodeBase64String(data);// ����Base64��������ֽ������ַ���
            //ɾ������ͼ�ļ�
            File comfile = new File(compressedFileName);
            comfile.delete();
            System.out.println("ɾ��FTP����������ʱ�ļ��ɹ�");
        }

        //��ǰ̨����json
        map.put("compressedBase64", compressedBase64);
        String jsonMap = JSON.toJSONString(map, true);
        writer.write(jsonMap);
        writer.flush();
        writer.close();
    }
  
    @ResponseBody
    @RequestMapping(value = "StoreModelFile", method = { RequestMethod.GET, RequestMethod.POST })
    public static String StoreModelFile(MultipartFile multipartFile) throws Exception {
        String fileDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String original_name = multipartFile.getOriginalFilename();
        StringBuilder sb = new StringBuilder(original_name);//����һ��StringBuilder����
        sb.insert(original_name.indexOf("."), "at" + fileDate.substring(8, 14));//���ļ��������ʱ��HHmmss��������
        String name = sb.toString();//ֱ�ӷ����ļ�������
        String filepath = "/Models/" + fileDate.substring(0, 4) + "/" + fileDate.substring(4, 6) + "-" //    FTP�������洢Ŀ¼��·��Ϊ/Models/xxxx-xx����-�£�/xx-xx����-Сʱ��/�ļ�
                + fileDate.substring(6, 8) + "/";
        FtpUtils ftputils = new FtpUtils();
        ftputils.uploadFile(filepath, name, multipartFile.getInputStream());//ģ���ļ�����FTP������
        System.out.println("ģ���ļ�����FTP�������ɹ�");
        return filepath + name;
    }

    @ResponseBody
    @RequestMapping(value = "UpdateRawImage", method = { RequestMethod.GET, RequestMethod.POST })
    public void UpdateRawImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String localname = request.getParameter("localname");
        System.out.println(localname);
        String localpath = localname.substring(0, localname.lastIndexOf("/"));
        String file_name = localname.substring(localname.lastIndexOf("/") + 1, localname.length());
        System.out.println("---------------- " + file_name);
        FtpUtils ftputils = new FtpUtils();
        ftputils.deleteFile(localpath, file_name);
        System.out.println("---------------- ɾ��ԭͼ�ɹ�");
        StoreRawImage(request, response);
        System.out.println("---------------- ����ͼƬ�ɹ�");
    }
}
