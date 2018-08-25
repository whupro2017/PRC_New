/**
 * 
 */
package com.whu.pro.mapper.param;

import java.sql.Timestamp;

/**
 * @author Michael
 *
 */
public class InfoTimeRangeQueryParam {
    private int id;
    private Timestamp beginTime;
    private Timestamp endTime;

    public int getId() {
        return id;
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
