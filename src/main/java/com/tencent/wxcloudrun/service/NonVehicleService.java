package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.NonVehicle;
import com.tencent.wxcloudrun.model.NonVehicleHis;

import java.util.List;

public interface NonVehicleService {


  int bindNonVehicle(NonVehicle nonVehicle);

  int unbindNonVehicle(NonVehicle nonVehicle);


  List<NonVehicle> findNonVehicleByNum(String novNum);

  List<NonVehicleHis> findHis(String novNum);

}
