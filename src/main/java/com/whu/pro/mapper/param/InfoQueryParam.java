/**
 * 
 */
package com.whu.pro.mapper.param;

import java.sql.Timestamp;

/**
 * @author Michael
 *
 */
public class InfoQueryParam {
    private int id;
    private double refx;
    private double refy;
    private double refz;
    private Timestamp beginTime;
    private Timestamp endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCenterx() {
        return refx;
    }

    public void setCenterx(double centerx) {
        this.refx = centerx;
    }

    public double getCentery() {
        return refy;
    }

    public void setCentery(double centery) {
        this.refy = centery;
    }

    public double getCenterz() {
        return refz;
    }

    public void setCenterz(double centerz) {
        this.refz = centerz;
    }

    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
}
