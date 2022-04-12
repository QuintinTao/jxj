package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Plan;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PlanMapper {

    int insert(Plan plan);
}
