package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {

    private String openid;

    private String sessionKey;

    private Integer height;

    private BigDecimal weight;

    private String sex;

    private String hobby;

    private String enjoyColor;

    private String dressingStyle;
}
