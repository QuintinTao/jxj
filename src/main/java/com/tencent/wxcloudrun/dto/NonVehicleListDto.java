package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.NonVehicle;
import lombok.Data;

import java.util.List;

@Data
public class NonVehicleListDto {

    private List<NonVehicle> nonVehicles;

    private int count;
}
