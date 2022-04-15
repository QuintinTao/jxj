package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.ext.NavCategoryExt;
import lombok.Data;

import java.util.List;

@Data
public class NavCategoryExtListDto {


    private List<NavCategoryExt> categories;

    private int count;
}
