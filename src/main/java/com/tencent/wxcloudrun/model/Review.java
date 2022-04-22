package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class Review {

    private Integer id;

    private Integer userId;

    private String content;

    private Integer bookId;

    private Long reviewTime;
}
