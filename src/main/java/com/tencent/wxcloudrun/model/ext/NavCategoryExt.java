package com.tencent.wxcloudrun.model.ext;

import com.tencent.wxcloudrun.model.NavCategory;
import com.tencent.wxcloudrun.model.NavPoint;
import lombok.Data;

import java.util.List;

@Data
public class NavCategoryExt extends NavCategory {
    private List<NavPoint> data;

}
