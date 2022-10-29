package com.tencent.wxcloudrun.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NonVehicleHis {

    private Integer id;

    private String name;

    private String novNum;

    private String sno;

    private String dept;

    private String starTimeStr;

    public String getStarTimeStr() {
        return starTimeStr;
    }

    public void setStarTimeStr(String starTimeStr) {
        this.starTimeStr = starTimeStr;
    }

    private Timestamp starTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNovNum() {
        return novNum;
    }

    public void setNovNum(String novNum) {
        this.novNum = novNum;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Timestamp getStarTime() {
        return starTime;
    }

    public void setStarTime(Timestamp starTime) {
        this.starTime = starTime;
        this.starTimeStr = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date(starTime.getTime()));
    }
}