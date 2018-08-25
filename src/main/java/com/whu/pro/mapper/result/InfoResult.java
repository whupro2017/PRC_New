/**
 * 
 */
package com.whu.pro.mapper.result;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 * @author Michael
 *
 */
public class InfoResult {
    private int id;
    private double centerx;
    private double centery;
    private String createTime;
    private double shiftx;
    private double shifty;
    private double shiftz;
    private double minx;
    private double miny;
    private double minz;
    private double maxx;
    private double maxy;
    private double maxz;
    private double mdnx;
    private double mdny;
    private double mdnz;
    private int minlevel;
    private int maxlevel;
    private Blob thumb;
    private String productstatus;
    private String comments;

    public int getId() {
        return id;
    }

    public double getCenterx() {
        return centerx;
    }

    public void setCenterx(double centerx) {
        this.centerx = centerx;
    }

    public double getCentery() {
        return centery;
    }

    public void setCentery(double centery) {
        this.centery = centery;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime.toString();
    }

    public double getShiftx() {
        return shiftx;
    }

    public void setShiftx(double shiftx) {
        this.shiftx = shiftx;
    }

    public double getShifty() {
        return shifty;
    }

    public void setShifty(double shifty) {
        this.shifty = shifty;
    }

    public double getShiftz() {
        return shiftz;
    }

    public void setShiftz(double shiftz) {
        this.shiftz = shiftz;
    }

    public double getMinx() {
        return minx;
    }

    public void setMinx(double minx) {
        this.minx = minx;
    }

    public double getMiny() {
        return miny;
    }

    public void setMiny(double miny) {
        this.miny = miny;
    }

    public double getMinz() {
        return minz;
    }

    public void setMinz(double minz) {
        this.minz = minz;
    }

    public double getMaxx() {
        return maxx;
    }

    public void setMaxx(double maxx) {
        this.maxx = maxx;
    }

    public double getMaxy() {
        return maxy;
    }

    public void setMaxy(double maxy) {
        this.maxy = maxy;
    }

    public double getMaxz() {
        return maxz;
    }

    public void setMaxz(double maxz) {
        this.maxz = maxz;
    }

    public double getMdnx() {
        return mdnx;
    }

    public void setMdnx(double mdnx) {
        this.mdnx = mdnx;
    }

    public double getMdny() {
        return mdny;
    }

    public void setMdny(double mdny) {
        this.mdny = mdny;
    }

    public double getMdnz() {
        return mdnz;
    }

    public void setMdnz(double mdnz) {
        this.mdnz = mdnz;
    }

    public int getMinlevel() {
        return minlevel;
    }

    public void setMinlevel(int minlevel) {
        this.minlevel = minlevel;
    }

    public int getMaxlevel() {
        return maxlevel;
    }

    public void setMaxlevel(int maxlevel) {
        this.maxlevel = maxlevel;
    }

    public Blob getThumb() {
        return thumb;
    }

    public void setThumb(Blob thumb) {
        this.thumb = thumb;
    }

    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
