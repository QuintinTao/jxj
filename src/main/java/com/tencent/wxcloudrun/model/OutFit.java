package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class OutFit {

    private Integer id;

    private Integer uid;

    private String pid; //seperated by ,

    private String picUrl;

    private Float score;

    private String title;

}
