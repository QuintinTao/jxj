package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.NonVehicle;
import com.tencent.wxcloudrun.model.Trip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface NonVehicleMapper {

    int insert(NonVehicle nonVehicle);

    int update(Trip trip);

    void deleteById(int id);

    List<NonVehicle> findNonVehicleByNum(String novNum);
}
