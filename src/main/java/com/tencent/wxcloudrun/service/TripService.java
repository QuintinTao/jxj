package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.model.Trip;

import java.util.List;

public interface TripService {

    int insert(Trip trip);

    int update(Trip trip);

    List<Trip> findTopTrips();
}
