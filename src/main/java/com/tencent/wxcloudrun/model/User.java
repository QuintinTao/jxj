package com.tencent.wxcloudrun.model;


import java.math.BigDecimal;

public class User {

    private Integer id;


    private String openid;

    private String session_key;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
        this.sessionKey = session_key;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getEnjoyColor() {
        return enjoyColor;
    }

    public void setEnjoyColor(String enjoyColor) {
        this.enjoyColor = enjoyColor;
    }

    public String getDressingStyle() {
        return dressingStyle;
    }

    public void setDressingStyle(String dressingStyle) {
        this.dressingStyle = dressingStyle;
    }

    private String sessionKey;

    private Integer height;

    private BigDecimal weight;

    private String sex;

    private String hobby;


    private String enjoyColor;

    private String dressingStyle;

    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
