package com.tencent.wxcloudrun.model;

import lombok.Data;

@Data
public class Exam {

    private Integer id;

    private Integer userId;

    private String content;

    private Integer examId;
}
