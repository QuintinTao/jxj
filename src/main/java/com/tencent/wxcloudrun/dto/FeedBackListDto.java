package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.FeedBack;
import lombok.Data;

import java.util.List;

@Data
public class FeedBackListDto {

    private List<FeedBack> feedBacks;

    private int count;
}
