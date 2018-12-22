import org.gdal.gdal.Dataset;
import org.gdal.gdal.Driver;
import org.gdal.gdal.gdal;
import org.gdal.gdalconst.gdalconstConstants;

public class GDAL_Resample {

    public static void main(String[] args) { // TODO Auto-generated method stub 
        CompressByGdal("E:\\Desktop\\18N084E.tif", "E:\\Desktop\\compressssssss.jpg"); //��ȡ��γ�� ����81.9993055555556 ��γ20.0006944444444

    }

    /**
     * @param input
     *            ����Ӱ��·��
     * @param output
     *            ���Ӱ��·��
     */

    public static void CompressByGdal(String input, String output) {
        //String agentfile=output.substring(0, output.lastIndexOf("."))+".tif"; 
        //ע��GDAL 
        gdal.AllRegister(); //ֻ����ʽ��ȡ���� 
        Dataset pSrc = gdal.Open(input, gdalconstConstants.GA_ReadOnly);
        if (pSrc == null)
            return; //�򿪵�Ӱ�����ء����ε���Ϣ 

        double[] adfGeoTransform = pSrc.GetGeoTransform();
        System.out.println("��õ�������");
        System.out.println(adfGeoTransform[0]);
        System.out.println(adfGeoTransform[3]);

        int numBands = pSrc.GetRasterCount(); //��ȡӰ�񲨶��� 
        int xSize = pSrc.GetRasterXSize();//դ��ߴ�
        int ySize = pSrc.GetRasterYSize();//    
        int depth = pSrc.GetRasterBand(1).GetRasterDataType();//ͼ�����
        int buf_xsize = 1000; //���û�����������ͼ����
        int buf_ysize = 1000 * ySize / xSize; //�߶����������Ӧ
        byte[] arr = new byte[numBands * buf_xsize * buf_ysize * depth];

        pSrc.ReadRaster(0, 0, xSize, ySize, buf_xsize, buf_ysize, gdalconstConstants.GDT_Byte, arr, null, 0); //ԭͼ���뻺������ѹ��

        //������ͼƬ
        Driver driver = gdal.GetDriverByName("MEM");
        driver.Register();
        String[] options = { "INTERLEAVE=PIXEL" };
        Dataset pDst = driver.Create("", buf_xsize, buf_ysize, numBands, depth, options);
        //�ӻ�������ȡ��Ϣ��ѹ��ͼ
        pDst.WriteRaster(0, 0, buf_xsize, buf_ysize, buf_xsize, buf_ysize, gdalconstConstants.GDT_Byte, arr, null, 0);
        Driver drijpg = gdal.GetDriverByName("JPEG");
        Dataset pDstjpg = drijpg.CreateCopy(output, pDst, 0);
        pDst.delete();
        pSrc.delete();
        pDstjpg.delete();
        System.out.println("Gdal��ȡ����ͼƬ����");
    }


}