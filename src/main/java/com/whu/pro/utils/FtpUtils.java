package com.whu.pro.utils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FtpUtils {
    //ftp��������ַ
    public String hostname = "127.0.0.1";
    //ftp�������˿ں�Ĭ��Ϊ21
    public Integer port = 21;
    //ftp��¼�˺�
    public String username = "user";
    //ftp��¼����
    public String password = "123";

    public FTPClient ftpClient = null;

    /**
     * ��ʼ��ftp������
     */
    public FTPClient initFtpClient() {
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(this.hostname, this.port);// ����FTP������
            ftpClient.login(this.username, this.password);// ��½FTP������
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("δ���ӵ�FTP���û������������");
                ftpClient.disconnect();
            } else {
                System.out.println("FTP���ӳɹ���");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("FTP��IP��ַ���ܴ�������ȷ���á�");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FTP�Ķ˿ڴ���,����ȷ���á�");
        }
        return ftpClient;
        /**
         * ftpClient.setControlEncoding("utf-8");
         * try {
         * System.out.println("connecting...ftp������:" + this.hostname + ":" + this.port);
         * ftpClient.connect(hostname, port); //����ftp������
         * ftpClient.login(username, password); //��¼ftp������
         * int replyCode = ftpClient.getReplyCode(); //�Ƿ�ɹ���¼������
         * if (!FTPReply.isPositiveCompletion(replyCode)) {
         * System.out.println("connect failed...ftp������:" + this.hostname + ":" + this.port);
         * }
         * System.out.println("connect successfu...ftp������:" + this.hostname + ":" + this.port);
         * } catch (MalformedURLException e) {
         * e.printStackTrace();
         * } catch (IOException e) {
         * e.printStackTrace();
         * }
         */
    }

    /**
     * �ϴ��ļ�
     * 
     * @param pathname
     *            ftp���񱣴��ַ
     * @param fileName
     *            �ϴ���ftp���ļ���
     * @param originfilename
     *            ���ϴ��ļ������ƣ����Ե�ַ�� *
     * @return
     */
    @SuppressWarnings("static-access")
    public boolean uploadFile(String pathname, String fileName, InputStream inputStream) {
        boolean flag = false;
        try {
            System.out.println("��ʼ�ϴ��ļ�");
            initFtpClient();
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            CreateDirecroty(pathname);
            ftpClient.makeDirectory(pathname);
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
            System.out.println("�ϴ��ļ��ɹ�");
        } catch (Exception e) {
            System.out.println("�ϴ��ļ�ʧ��");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
    
    /**
     * �ϴ��ļ�
     * 
     * @param pathname
     *            ftp���񱣴��ַ
     * @param fileName
     *            �ϴ���ftp���ļ���
     * @param inputStream
     *            �����ļ���
     * @return
     */
    /*  public boolean uploadFile(String pathname, String fileName, InputStream inputStream) {
        boolean flag = false;
        try {
            System.out.println("��ʼ�ϴ��ļ�");
            initFtpClient();
            ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
            CreateDirecroty(pathname);
            ftpClient.makeDirectory(pathname);
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
            System.out.println("�ϴ��ļ��ɹ�");
        } catch (Exception e) {
            System.out.println("�ϴ��ļ�ʧ��");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    */
    //�ı�Ŀ¼·��
    public boolean changeWorkingDirectory(String directory) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                System.out.println("�����ļ���" + directory + " �ɹ���");

            } else {
                System.out.println("�����ļ���" + directory + " ʧ�ܣ���ʼ�����ļ���");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            }
        return flag;
        }

    //�������Ŀ¼�ļ��������ftp�������Ѵ��ڸ��ļ����򲻴���������ޣ��򴴽�
    public boolean CreateDirecroty(String remote) throws IOException {
        boolean flag = true;
        String directory = remote + "/";
        // ���Զ��Ŀ¼�����ڣ���ݹ鴴��Զ�̷�����Ŀ¼
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {
                String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + "/" + subDirectory;
                System.out.println("path��" + path);
                if (!existFile(path)) {
                    if (makeDirectory(subDirectory)) {
                        changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("����Ŀ¼[" + subDirectory + "]ʧ��");
                        changeWorkingDirectory(subDirectory);
                    }
                } else {
                    changeWorkingDirectory(subDirectory);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // �������Ŀ¼�Ƿ񴴽����
                if (end <= start) {
                    break;
                }
            }
        }
        return flag;
    }

    //�ж�ftp�������ļ��Ƿ����    
    public boolean existFile(String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
        }
    //����Ŀ¼
    public boolean makeDirectory(String dir) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                System.out.println("�����ļ���" + dir + " �ɹ���");

            } else {
                System.out.println("�����ļ���" + dir + " ʧ�ܣ�");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * * �����ļ� *
     * 
     * @param pathname
     *            FTP�������ļ�Ŀ¼ *
     * @param filename
     *            �ļ����� *
     * @param localpath
     *            ���غ���ļ�·�� *
     * @return
     */
    public boolean downloadFile(String pathname, String filename, String localpath) {
        boolean flag = false;
        OutputStream os = null;
        try {
            System.out.println("��ʼ�����ļ�");
            initFtpClient();
            //�л�FTPĿ¼ 
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for (FTPFile file : ftpFiles) {
                if (filename.equalsIgnoreCase(file.getName())) {
                    File localFile = new File(localpath + "/" + file.getName());
                    os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(file.getName(), os);
                    os.close();
                }
            }
            ftpClient.logout();
            flag = true;
            System.out.println("�����ļ��ɹ�");
        } catch (Exception e) {
            System.out.println("�����ļ�ʧ��");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    /**
     * * ɾ���ļ� *
     * 
     * @param pathname
     *            FTP����������Ŀ¼ *
     * @param filename
     *            Ҫɾ�����ļ����� *
     * @return
     */
    public boolean deleteFile(String pathname, String filename) {
        boolean flag = false;
        try {
            System.out.println("��ʼɾ���ļ�");
            initFtpClient();
            //�л�FTPĿ¼ 
            ftpClient.changeWorkingDirectory(pathname);
            int x = ftpClient.dele(filename);
            ftpClient.logout();
            flag = true;
            if (x != 550) {
            System.out.println("ɾ���ļ��ɹ�" + x);
            } else {
                System.out.println("ɾ���ļ�ʧ��");
            }

        } catch (Exception e) {
            System.out.println("ɾ���ļ�ʧ��");
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        FtpUtils ftp = new FtpUtils();
        //ftp.uploadFile("ftpFile/data", "123.docx", "E://123.docx");
        //ftp.downloadFile("ftpFile/data", "123.docx", "F://");
        ftp.deleteFile("ftpFile/data", "123.docx");
        System.out.println("ok");
    }
}
