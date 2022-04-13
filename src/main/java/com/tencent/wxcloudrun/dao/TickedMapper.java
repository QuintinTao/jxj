package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.model.Ticked;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TickedMapper {

    int insert(Ticked Ticked);

    List<Ticked> findTodayTicked();

    List<Ticked> findTickedByUserId(Integer userId);
}
