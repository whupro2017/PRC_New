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
        //�ϴ�һ���ļ�
        InputStream inputStream = new FileInputStream(new File(originfilename));
        boolean test = ftputils.uploadFile(pathname, filename, inputStream);
        System.out.println(test);
        //ftputils.deleteFile(pathname, "22.txt");
        
        
        //����һ���ļ�
        boolean test1 = ftputils.downloadFile(pathname, filename, localpath);
        System.out.println("���ؽ����" + test1);
        
        //ɾ��һ���ļ�
        boolean test3 = ftputils.deleteFile(pathname, filename);
        System.out.println("ɾ�������" + test3);
    }
}