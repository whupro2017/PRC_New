package com.whu.pro.utils;
import org.gdal.gdal.Dataset;
import org.gdal.gdal.Driver;
import org.gdal.gdal.gdal;
import org.gdal.gdalconst.gdalconstConstants;

public class GdalUtils {

    public static void main(String[] args) { // TODO Auto-generated method stub 
        CompressByGdal("E:\\Desktop\\download (1).JPG", "E:\\Desktop\\compressssssss.tif");
    }

    /**
     * @param input
     *            输入影像路径
     * @param output
     *            输出影像路径
     */

    public static void CompressByGdal(String input, String output) {
        //String agentfile=output.substring(0, output.lastIndexOf("."))+".tif"; 
        //注册GDAL 
        System.out.println("Gdal开始抽取超大图片");
        gdal.AllRegister(); //只读方式读取数据 
        Dataset pSrc = gdal.Open(input, gdalconstConstants.GA_ReadOnly);
        if (pSrc == null)
            return; //打开的影像像素、波段等信息 
        int numBands = pSrc.GetRasterCount(); //读取影像波段数 
        int xSize = pSrc.GetRasterXSize();//栅格尺寸
        int ySize = pSrc.GetRasterYSize();//    
        int depth = pSrc.GetRasterBand(1).GetRasterDataType();//图像深度
        int buf_xsize = 2000; //设置缓存区及缩略图宽度
        int buf_ysize = 2000 * ySize / xSize; //高度随宽度自适应
        byte[] arr = new byte[numBands * buf_xsize * buf_ysize * depth];
        pSrc.ReadRaster(0, 0, xSize, ySize, buf_xsize, buf_ysize, gdalconstConstants.GDT_Byte, arr, null, 0); //原图存入缓存区并压缩

        //创建新图片
        Driver driver = gdal.GetDriverByName("MEM");
        driver.Register();
        String[] options = { "INTERLEAVE=PIXEL" };
        Dataset pDst = driver.Create("", buf_xsize, buf_ysize, numBands, depth, options);
        //从缓存区读取信息至压缩图
        pDst.WriteRaster(0, 0, buf_xsize, buf_ysize, buf_xsize, buf_ysize, gdalconstConstants.GDT_Byte, arr, null, 0);
        Driver drijpg = gdal.GetDriverByName("JPEG");
        Dataset pDstjpg = drijpg.CreateCopy(output, pDst, 0);
        pDst.delete();
        pSrc.delete();
        pDstjpg.delete();
        System.out.println("Gdal抽取超大图片结束");
    }


}