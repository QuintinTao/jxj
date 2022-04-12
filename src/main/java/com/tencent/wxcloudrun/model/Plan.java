package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class Plan {

    private Integer id;

    private String startTime;

    private String endTime;

    private Integer userId;
}
