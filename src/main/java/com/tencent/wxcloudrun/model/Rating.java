package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class Rating {

    private Integer id;

    private Integer uid;

    private Integer pid;

    private Float score;

}
