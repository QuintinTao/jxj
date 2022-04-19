package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class NavPoint {
    private Integer pid;
    private Integer cid;
    private String pointName;
    private String latitude;
    private String longitude;
    private String pointImage;
    private String address;
    private String story;
}
