package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.NavPoint;
import com.tencent.wxcloudrun.model.ext.NavCategoryExt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface NavPointMapper {

    int insert(NavPoint point);

    List<NavPoint> findAllNavPoints();

}
