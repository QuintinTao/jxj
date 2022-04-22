package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.OutFit;
import com.tencent.wxcloudrun.model.Pic;
import lombok.Data;

import java.util.List;

@Data
public class OutFitListDto {

    private List<OutFit> outFits;

    private int count;
}
