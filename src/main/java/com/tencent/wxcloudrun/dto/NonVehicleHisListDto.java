package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.NonVehicleHis;
import lombok.Data;

import java.util.List;

@Data
public class NonVehicleHisListDto {

    private List<NonVehicleHis> nonVehicleHis;

    private int count;
}
