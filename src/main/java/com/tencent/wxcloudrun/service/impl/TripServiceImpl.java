package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.TripMapper;
import com.tencent.wxcloudrun.model.Trip;
import com.tencent.wxcloudrun.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    final TripMapper tripMapper;

    public TripServiceImpl(@Autowired TripMapper tripMapper) {
        this.tripMapper = tripMapper;
    }

    @Override
    public int insert(Trip trip) {
        tripMapper.insert(trip);
        return trip.getId();
    }

    @Override
    public int update(Trip trip) {
        return tripMapper.update(trip);
    }

    @Override
    public List<Trip> findTopTrips() {
        return tripMapper.findTopTrips();
    }

}
