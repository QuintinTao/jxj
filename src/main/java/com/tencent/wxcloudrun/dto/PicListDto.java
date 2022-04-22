package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Pic;
import lombok.Data;

import java.util.List;

@Data
public class PicListDto {

    private List<Pic> pics;

    private int count;
}
