package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.TripLog;
import lombok.Data;

import java.util.List;

@Data
public class TripLogListDto {


    private List<TripLog> logs;

    private int count;
}
