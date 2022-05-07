package com.tencent.wxcloudrun.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FeedBack {

    private Integer id;

    private String question;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private String user;

    public String getfTimeStr() {
        return fTimeStr;
    }

    public void setfTimeStr(String fTimeStr) {
        this.fTimeStr = fTimeStr;
    }

    private String feedback;

    private String fTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Timestamp getfTime() {
        return fTime;
    }

    public void setfTime(Timestamp fTime) {
        this.fTime = fTime;
        this.fTimeStr = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date(fTime.getTime()));
    }

    private Timestamp fTime;


}
