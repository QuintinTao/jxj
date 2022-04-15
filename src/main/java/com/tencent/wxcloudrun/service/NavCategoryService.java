package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ext.NavCategoryExt;

import java.util.List;

public interface NavCategoryService {

    List<NavCategoryExt> findAllNavPoints();
}
