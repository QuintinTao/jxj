package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.NavPoint;

import java.util.List;

public interface NavPointService {

    int insert(NavPoint point);

    List<NavPoint> findAllNavPoints();
}
