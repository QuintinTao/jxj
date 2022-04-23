package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class TripLog {

    private Integer id;

    private String startGps;

    private String endGps;

    private String tripName;

    private String startName;

    private String endName;
}
