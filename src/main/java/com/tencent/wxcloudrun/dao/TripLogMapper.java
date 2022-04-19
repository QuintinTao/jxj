package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.TripLog;
import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TripLogMapper {

    int insert(TripLog tripLog);

    List<TripLog> findTopTripLogs();
}
