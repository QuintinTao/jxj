package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.NavCategoryMapper;
import com.tencent.wxcloudrun.dao.NavPointMapper;
import com.tencent.wxcloudrun.model.NavPoint;
import com.tencent.wxcloudrun.service.NavPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavPointServiceImpl implements NavPointService {

    final NavPointMapper navPointMapper;

    public NavPointServiceImpl(@Autowired NavPointMapper navPointMapper) {
        this.navPointMapper = navPointMapper;
    }

    @Override
    public int insert(NavPoint point) {

        return navPointMapper.insert(point);
    }

    @Override
    public List<NavPoint> findAllNavPoints() {

        return navPointMapper.findAllNavPoints();
    }
}
