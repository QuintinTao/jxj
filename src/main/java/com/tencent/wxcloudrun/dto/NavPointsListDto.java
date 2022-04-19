package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.NavPoint;
import lombok.Data;

import java.util.List;

@Data
public class NavPointsListDto {

    private List<NavPoint> points;

    private int count;
}
