package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Trip;
import lombok.Data;

import java.util.List;

@Data
public class TripListDto {


    private List<Trip> trips;

    private int count;
}
