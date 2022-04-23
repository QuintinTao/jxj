package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShareLog {

    private Integer id;

    private String fromStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromStr() {
        return fromStr;
    }

    public void setFromStr(String fromStr) {
        this.fromStr = fromStr;
    }

    public Timestamp getShareTime() {
        return shareTime;
    }

    public void setShareTime(Timestamp shareTime) {
        this.shareTime = shareTime;
        this.shareTimeStr = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date(shareTime.getTime()));
    }

    public String getShareTimeStr() {
        return shareTimeStr;
    }

    public void setShareTimeStr(String shareTimeStr) {
        this.shareTimeStr = shareTimeStr;
    }

    private Timestamp shareTime;

    private String shareTimeStr;


}
