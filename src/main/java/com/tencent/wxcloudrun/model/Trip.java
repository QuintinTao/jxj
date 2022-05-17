package com.tencent.wxcloudrun.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Trip {

    private Integer id;

    private String startGps;

    private String endGps;

    private Timestamp startTime;

    private Timestamp endTime;

    private BigDecimal cost;

    private String startTimeStr;

    private String endTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartGps() {
        return startGps;
    }

    public void setStartGps(String startGps) {
        this.startGps = startGps;
    }

    public String getEndGps() {
        return endGps;
    }

    public void setEndGps(String endGps) {
        this.endGps = endGps;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
        this.startTimeStr = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date(startTime.getTime()));
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
        this.endTimeStr = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date(endTime.getTime()));
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }
}
