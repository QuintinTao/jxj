package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.NonVehicleHis;
import com.tencent.wxcloudrun.model.TripLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface NonVehicleHisMapper {

    int insert(NonVehicleHis nonVehicleHis);

    List<NonVehicleHis> findHis(String novNum);
}
