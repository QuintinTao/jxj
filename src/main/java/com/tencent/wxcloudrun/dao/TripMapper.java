package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Trip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TripMapper {

    int insert(Trip trip);

    int update(Trip trip);

    List<Trip> findTopTrips();
}
