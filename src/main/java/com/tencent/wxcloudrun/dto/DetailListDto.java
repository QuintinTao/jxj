package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Detail;
import lombok.Data;

import java.util.List;
@Data
public class DetailListDto {

    private List<Detail> details;

    private int count;
}
