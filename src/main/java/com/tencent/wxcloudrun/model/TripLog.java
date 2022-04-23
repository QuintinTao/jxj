package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TripLog {

    private Integer id;

    private String startGps;

    private String endGps;

    private String tripName;

    private String startName;

    private String endName;

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

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }

    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName;
    }

    public Timestamp getTripTime() {
        return tripTime;
    }

    public void setTripTime(Timestamp tripTime) {
        this.tripTime = tripTime;
        this.tripTimeStr = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date(tripTime.getTime()));
    }

    public String getTripTimeStr() {
        return tripTimeStr;
    }

    public void setTripTimeStr(String tripTimeStr) {
        this.tripTimeStr = tripTimeStr;
    }

    private Timestamp tripTime;

    private String tripTimeStr;




}
