package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.NavCategoryMapper;
import com.tencent.wxcloudrun.model.ext.NavCategoryExt;
import com.tencent.wxcloudrun.service.NavCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavCategoryServiceImpl implements NavCategoryService {

    final NavCategoryMapper navCategoryMapper;

    public NavCategoryServiceImpl(@Autowired NavCategoryMapper navCategoryMapper) {
        this.navCategoryMapper = navCategoryMapper;
    }

    @Override
    public List<NavCategoryExt> findAllNavPoints() {
        return navCategoryMapper.findAllNavPoints();
    }
}
