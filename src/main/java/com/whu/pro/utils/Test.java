package com.whu.pro.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        FtpUtils ftputils = new FtpUtils();
        String pathname = "/a/b/c";
        String originfilename = "E:/Desktop/u=733106045,1983072647&fm=200&gp=0.jpg";
        String filename = "test.jpg";
        String localpath = "E:/Desktop/program";
        //上传一个文件
        InputStream inputStream = new FileInputStream(new File(originfilename));
        boolean test = ftputils.uploadFile(pathname, filename, inputStream);
        System.out.println(test);
        //ftputils.deleteFile(pathname, "22.txt");
        
        
        //下载一个文件
        boolean test1 = ftputils.downloadFile(pathname, filename, localpath);
        System.out.println("下载结果：" + test1);
        
        //删除一个文件
        boolean test3 = ftputils.deleteFile(pathname, filename);
        System.out.println("删除结果：" + test3);
    }
}