package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ShareLog {

    private Integer id;

    private String fromStr;

    private Timestamp shareTime;
}
