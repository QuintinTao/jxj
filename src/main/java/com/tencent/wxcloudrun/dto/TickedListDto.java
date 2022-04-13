package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Ticked;
import lombok.Data;

import java.util.List;

@Data
public class TickedListDto {


    private List<Ticked> ticks;

    private int count;
}
