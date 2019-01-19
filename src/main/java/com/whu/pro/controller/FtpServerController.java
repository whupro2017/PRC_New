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
        MultipartFile multipartFile = multipartRequest.getFile("file");//file是form-data中二进制字段对应的name
        String image_length = multipartRequest.getParameter("image_length");
        // String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());//这里取得文件后缀
        String fileDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String original_name = multipartFile.getOriginalFilename();
        StringBuilder sb = new StringBuilder(original_name);//构造一个StringBuilder对象
        sb.insert(original_name.indexOf("."), "at" + fileDate.substring(8, 14));//在文件名后添加时间HHmmss避免重名
        String name = sb.toString();//得到存入文件名
        String filepath = "/images/RawImages/" + fileDate.substring(0, 4) + "/" + fileDate.substring(4, 6) + "-" //    FTP服务器存储目录下路径为/images/BigRawImages/xxxx（年）/xx-xx（月-日）/文件
                + fileDate.substring(6, 8) + "/";

        FtpUtils ftputils = new FtpUtils();
        ftputils.uploadFile(filepath, name, multipartFile.getInputStream());//原始图片存入FTP服务器

        // 返回图片本地地址到前台存入数据库
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        Map<String, String> map = new HashMap<>();
        String localname = filepath + name;
        map.put("localname", localname); //localname用于下载FTP服务器上文件
        String compressedBase64 = "";

        //若图片大于1.5M,将图片暂存至FTP服务器抽取缩略图，并返回缩略图base64字符串到前台
        if (Integer.parseInt(image_length) >= 1500000) {
            String tempImageName = UUID.randomUUID().toString() + ".jpg";// 构建随机文件名称
            String compressedFileName = "E:/FTPServer" + filepath + tempImageName; //FTP上临时抽取文件路径
            GdalUtils.CompressByGdal("E:/FTPServer" + localname, compressedFileName);

            //将缩略图转为base64字符串传向前台
            InputStream in = null;
            byte[] data = null;
            try { // 读取图片字节数组
                in = new FileInputStream(compressedFileName);

                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            compressedBase64 = "data:image/jpeg;base64," + Base64.encodeBase64String(data);// 返回Base64编码过的字节数组字符串
            //删除缩略图文件
            File comfile = new File(compressedFileName);
            comfile.delete();
            System.out.println("删除FTP服务器上临时文件成功");
        }

        //向前台返回json
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
        StringBuilder sb = new StringBuilder(original_name);//构造一个StringBuilder对象
        sb.insert(original_name.indexOf("."), "at" + fileDate.substring(8, 14));//在文件名后添加时间HHmmss避免重名
        String name = sb.toString();//直接返回文件的名字
        String filepath = "/Models/" + fileDate.substring(0, 4) + "/" + fileDate.substring(4, 6) + "-" //    FTP服务器存储目录下路径为/Models/xxxx-xx（年-月）/xx-xx（日-小时）/文件
                + fileDate.substring(6, 8) + "/";
        FtpUtils ftputils = new FtpUtils();
        ftputils.uploadFile(filepath, name, multipartFile.getInputStream());//模型文件存入FTP服务器
        System.out.println("模型文件存入FTP服务器成功");
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
        System.out.println("---------------- 删除原图成功");
        StoreRawImage(request, response);
        System.out.println("---------------- 更新图片成功");
    }
}
