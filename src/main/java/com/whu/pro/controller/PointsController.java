package com.whu.pro.controller;

import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whu.pro.mapper.param.PointsParam;
import com.whu.pro.mapper.param.PointsParam1;
import com.whu.pro.mapper.result.ColorPointResult;
import com.whu.pro.mapper.result.PointResult;
import com.whu.pro.misc.BernoulliSampler;
import com.whu.pro.service.PointsService;

import algorithm.Hilbert;
import storage.Point;
import storage.Range;

@Controller
@RequestMapping("PointsController")
public class PointsController {
    @Resource
    private PointsService pointsService;

    @ResponseBody
    @RequestMapping(value = "getAllPoints", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getAllPoints(String minx, String miny, String minz, String maxx, String maxy, String maxz,
            String level) throws SQLException {
        //		Point center = new Point(500000, 500000, 300000);
        Point leftBottom = new Point(Double.parseDouble(minx), Double.parseDouble(miny), Double.parseDouble(minz));
        Point rightTop = new Point(Double.parseDouble(maxx), Double.parseDouble(maxy), Double.parseDouble(maxz));
        //		Hilbert hilbert = new Hilbert(center, 500000, 22);
        List<Range> rangeList = Hilbert.getRange(Integer.parseInt(level), leftBottom, rightTop);
        ArrayList<PointResult> res = new ArrayList<PointResult>();
        System.out.println("----------------Points Range:" + rangeList.size());
        int count = 0;
        for (int i = 0; i < rangeList.size(); i++) {
            Range r = rangeList.get(i);
            long beginHcode = r.getBegin().getHigh();
            long beginLcode = r.getBegin().getLow();
            long endHcode = r.getEnd().getHigh();
            long endLcode = r.getEnd().getLow();
            if (beginHcode == endHcode) {
                PointsParam1 pp = new PointsParam1();
                pp.setEqualHcode(beginHcode);
                pp.setMinLcode(beginLcode);
                pp.setMaxLcode(endLcode);
                ArrayList<PointResult> arr1 = pointsService.getAllPoints1(pp);
                if (arr1 != null) {
                    /*for(int j = 0; j < arr1.size(); j++) {
                    	count += arr1.get(j).split(";").length;
                    }*/
                    Iterator<PointResult> iter = arr1.iterator();
                    while (iter.hasNext()) {
                        PointResult a = iter.next();
                        if (a != null) {
                            byte[] bs = a.getData();//a.getBytes(1, (int) a.length());
                            count += bs.length / (Float.BYTES * 4 + Short.BYTES * 3);
                        } else {
                            iter.remove();
                        }
                    }
                    res.addAll(arr1);
                }
            } else {
                PointsParam pp = new PointsParam();
                pp.setMinHcode(beginHcode);
                pp.setMinLcode(beginLcode);
                pp.setMaxHcode(endHcode);
                pp.setMaxLcode(endLcode);
                ArrayList<PointResult> arr = pointsService.getAllPoints(pp);
                if (arr != null) {
                    /*for(int j = 0; j < arr.size(); j++) {
                        count += arr.get(j).split(";").length;
                    }*/
                    Iterator<PointResult> iter = arr.iterator();
                    while (iter.hasNext()) {
                        PointResult a = iter.next();
                        if (a != null) {
                            byte[] bs = a.getData();//a.getBytes(1, (int) a.length());
                            count += bs.length / (Float.BYTES * 4 + Short.BYTES * 3);
                        } else {
                            iter.remove();
                        }
                    }
                    res.addAll(arr);
                }
            }
        }
        System.out.println("----------------Points:" + res.size());
        System.out.println("----------------Points count:" + count);
        return res;
    }

    @ResponseBody
    @RequestMapping(value = "getAllColorPoints", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getAllColorPoints(String minx, String miny, String minz, String maxx, String maxy, String maxz,
            String level) throws SQLException, Exception {
        //		Point center = new Point(500000, 500000, 300000);
        Point leftBottom = new Point(Double.parseDouble(minx), Double.parseDouble(miny), Double.parseDouble(minz));
        Point rightTop = new Point(Double.parseDouble(maxx), Double.parseDouble(maxy), Double.parseDouble(maxz));
        ArrayList<ColorPointResult> center = new ArrayList<ColorPointResult>();
        float mx = Float.parseFloat(minx);
        float my = Float.parseFloat(miny);
        float mz = Float.parseFloat(minz);

        int split = 5;

        float xx = (Float.parseFloat(maxx) - mx) / split;
        float yy = (Float.parseFloat(maxy) - my) / split;
        float zz = (Float.parseFloat(maxz) - mz) / split;

        float[] cenx = new float[split];
        float[] ceny = new float[split];
        float[] cenz = new float[split];
        mx += xx / 2;
        my += yy / 2;
        mz += zz / 2;
        for (int i = 0; i < split; i++) {
            cenx[i] = mx;
            ceny[i] = my;
            cenz[i] = mz;
            mx += xx;
            my += yy;
            mz += zz;
        }

        for (int i = 0; i < split; i++) {
            for (int j = 0; j < split; j++) {
                for (int k = 0; k < split; k++) {
                    center.add(new ColorPointResult(cenx[i], ceny[j], cenz[k]));
                }
            }
        }

        //		Hilbert hilbert = new Hilbert(center, 500000, 22);
        long begin = System.currentTimeMillis();
        List<Range> rangeList = Hilbert.getRange(Integer.parseInt(level), leftBottom, rightTop);
        System.out.println("Rec: " + leftBottom.toString() + "<->" + rightTop.toString() + "@" + level + " elipsed: "
                + (System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        //        ArrayList<byte[]> res = new ArrayList<>();
        ArrayList<ColorPointResult> res = new ArrayList<ColorPointResult>();
        int FLOAT_LENGTH = Float.BYTES;
        int SHORT_LENGTH = Short.BYTES;
        int DATA_LENGTH = FLOAT_LENGTH * 4 + SHORT_LENGTH * 3;
        System.out.println("++++++++++++++++Color Points Range:" + rangeList.size());
        int count = 0;
        int num = 0;

        for (int i = 0; i < rangeList.size(); i++) {
            Range r = rangeList.get(i);
            long beginHcode = r.getBegin().getHigh();
            long beginLcode = r.getBegin().getLow();
            long endHcode = r.getEnd().getHigh();
            long endLcode = r.getEnd().getLow();
            //System.out.println(i + ":" + beginHcode + "-" + endHcode + ":" + beginLcode + "-" + endLcode);
            if (beginHcode == endHcode) {
                PointsParam1 pp = new PointsParam1();
                pp.setEqualHcode(beginHcode);
                pp.setMinLcode(beginLcode);
                pp.setMaxLcode(endLcode);
                num += pointsService.getCountColorPoints1(pp);
            } else {
                PointsParam pp = new PointsParam();
                pp.setMinHcode(beginHcode);
                pp.setMinLcode(beginLcode);
                pp.setMaxHcode(endHcode);
                pp.setMaxLcode(endLcode);
                num += pointsService.getCountColorPoints(pp);
            }
        }

        double perf = (double) 19999999 / num;
        if (num < 500000) {
            perf = 1;
        } else if (num > 3000000) {
            perf *= 3;
        }
        perf = Math.min(perf, 1.0);
        System.out.println("++++++++++++++++num point is: " + num + " and perf is" + perf);

        BernoulliSampler bsa = new BernoulliSampler(perf);
        for (int i = 0; i < rangeList.size(); i++) {
            Range r = rangeList.get(i);
            long beginHcode = r.getBegin().getHigh();
            long beginLcode = r.getBegin().getLow();
            long endHcode = r.getEnd().getHigh();
            long endLcode = r.getEnd().getLow();
            //System.out.println(i + ":" + beginHcode + "-" + endHcode + ":" + beginLcode + "-" + endLcode);
            if (beginHcode == endHcode) {
                PointsParam1 pp = new PointsParam1();
                pp.setEqualHcode(beginHcode);
                pp.setMinLcode(beginLcode);
                pp.setMaxLcode(endLcode);
                ArrayList<PointResult> arr1 = pointsService.getAllColorPoints1(pp);
                if (arr1 != null) {
                    /*for(int j = 0; j < arr1.size(); j++) {
                    	count += arr1.get(j).split(";").length;
                    }*/
                    Iterator<PointResult> iter = arr1.iterator();
                    while (iter.hasNext()) {
                        //Blob a = iter.next();
                        PointResult a = iter.next();
                        if (a != null && bsa.check()) {
                            byte[] bs = a.getData(); //a.getBytes(1, (int) a.length());
                            int cc = bs.length / DATA_LENGTH;
                            count += cc;
                            for (int j = 0; j < cc; j++) {
                                float x = ByteBuffer.wrap(bs, j * DATA_LENGTH, FLOAT_LENGTH).getFloat();
                                float y = ByteBuffer.wrap(bs, j * DATA_LENGTH + 4, FLOAT_LENGTH).getFloat();
                                float z = ByteBuffer.wrap(bs, j * DATA_LENGTH + 8, FLOAT_LENGTH).getFloat();
                                int cr = ByteBuffer.wrap(bs, j * DATA_LENGTH + 16, SHORT_LENGTH).getShort();
                                int cg = ByteBuffer.wrap(bs, j * DATA_LENGTH + 18, SHORT_LENGTH).getShort();
                                int cb = ByteBuffer.wrap(bs, j * DATA_LENGTH + 20, SHORT_LENGTH).getShort();
                                ColorPointResult rr = new ColorPointResult(x, y, z, cr, cg, cb);
                                res.add(rr);
                            }
                            //                            res.add(bs);
                        } else {
                            iter.remove();
                        }
                    }
                    //res.addAll(arr1);
                }
            } else {
                PointsParam pp = new PointsParam();
                pp.setMinHcode(beginHcode);
                pp.setMinLcode(beginLcode);
                pp.setMaxHcode(endHcode);
                pp.setMaxLcode(endLcode);
                ArrayList<PointResult> arr = pointsService.getAllColorPoints(pp);
                if (arr != null) {
                    /*for(int j = 0; j < arr.size(); j++) {
                    	count += arr.get(j).split(";").length;
                    }*/
                    Iterator<PointResult> iter = arr.iterator();
                    while (iter.hasNext()) {
                        PointResult a = iter.next();
                        if (a != null && bsa.check()) {
                            byte[] bs = a.getData(); //a.getBytes(1, (int) a.length());
                            int cc = bs.length / DATA_LENGTH;
                            count += cc;
                            for (int j = 0; j < cc; j++) {
                                float x = ByteBuffer.wrap(bs, j * DATA_LENGTH, FLOAT_LENGTH).getFloat();
                                float y = ByteBuffer.wrap(bs, j * DATA_LENGTH + 4, FLOAT_LENGTH).getFloat();
                                float z = ByteBuffer.wrap(bs, j * DATA_LENGTH + 8, FLOAT_LENGTH).getFloat();
                                int cr = ByteBuffer.wrap(bs, j * DATA_LENGTH + 16, SHORT_LENGTH).getShort();
                                int cg = ByteBuffer.wrap(bs, j * DATA_LENGTH + 18, SHORT_LENGTH).getShort();
                                int cb = ByteBuffer.wrap(bs, j * DATA_LENGTH + 20, SHORT_LENGTH).getShort();
                                ColorPointResult rr = new ColorPointResult(x, y, z, cr, cg, cb);
                                res.add(rr);
                            }
                            //                            res.add(bs);
                        } else {
                            iter.remove();
                        }
                    }
                    //res.addAll(arr);
                }
            }
        }
        System.out.println(
                "++++++++++++++++Color Points:" + res.size() + " dbaccess: " + (System.currentTimeMillis() - begin));
        System.out.println("++++++++++++++++Color Points count:" + count);

        center.addAll(res);
        return center;
        //        int FLOAT_LENGTH = Float.BYTES;
        //        int SHORT_LENGTH = Short.BYTES;
        //        int DATA_LENGTH = FLOAT_LENGTH * 4 + SHORT_LENGTH * 3;
        //        List<String> resStr = new ArrayList<>();
        //        begin = System.currentTimeMillis();
        //        for (byte[] br : res) {
        //            if (br != null) {
        //                byte[] bs = br;//br.getBytes(1, (int) br.length());
        //                int totalPoints = bs.length / DATA_LENGTH;
        //                for (int i = 0; i < totalPoints; i++) {
        //                    StringBuilder sb = new StringBuilder();
        //                    String str = "";
        //                    int offset = DATA_LENGTH * i;
        //                    ByteBuffer buf = ByteBuffer.wrap(bs, offset + 0 * FLOAT_LENGTH, FLOAT_LENGTH);
        //                    float x = buf.getFloat();
        //                    /*str += x;
        //                    str += ",";*/
        //                    sb.append(x).append(",");
        //                    buf = ByteBuffer.wrap(bs, offset + 1 * FLOAT_LENGTH, FLOAT_LENGTH);
        //                    float y = buf.getFloat();
        //                    /*str += y;
        //                    str += ",";*/
        //                    sb.append(y).append(",");
        //                    buf = ByteBuffer.wrap(bs, offset + 2 * FLOAT_LENGTH, FLOAT_LENGTH);
        //                    float z = buf.getFloat();
        //                    /*str += z;
        //                    str += ",";*/
        //                    sb.append(z).append(",");
        //                    buf = ByteBuffer.wrap(bs, offset + 3 * FLOAT_LENGTH, FLOAT_LENGTH);
        //                    @SuppressWarnings("unused")
        //                    float d = buf.getFloat();
        //                    buf = ByteBuffer.wrap(bs, offset + 4 * FLOAT_LENGTH + 0 * SHORT_LENGTH, SHORT_LENGTH);
        //                    short r = buf.getShort();
        //                    /*str += r;
        //                    str += ",";*/
        //                    sb.append(r).append(",");
        //                    buf = ByteBuffer.wrap(bs, offset + 4 * FLOAT_LENGTH + 1 * SHORT_LENGTH, SHORT_LENGTH);
        //                    short g = buf.getShort();
        //                    /*str += g;
        //                    str += ",";*/
        //                    sb.append(g).append(",");
        //                    buf = ByteBuffer.wrap(bs, offset + 4 * FLOAT_LENGTH + 2 * SHORT_LENGTH, SHORT_LENGTH);
        //                    short b = buf.getShort();
        //                    /*str += b;*/
        //                    sb.append(b);
        //                    /*if (i < totalPoints - 1) {
        //                        str += ";";
        //                        sb.append(";");
        //                    }*/
        //                    str = sb.toString();
        //                    resStr.add(str);
        //                    //System.out.println(" x: " + x + " y: " + y + " z: " + z + " r: " + r + " g: " + g + " b: " + b);
        //                }
        //                //System.out.println(str);
        //            }
        //        }
        //        System.out.println("Concat elipsed: " + (System.currentTimeMillis() - begin) / 1000);
        //        return resStr;
    }
}
