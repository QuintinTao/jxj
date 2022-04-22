package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Rating;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RatingMapper {

    List<Rating> findAll();

    int insert(Rating rating);

}
