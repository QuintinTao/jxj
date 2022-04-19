package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.TripLogMapper;
import com.tencent.wxcloudrun.model.TripLog;
import com.tencent.wxcloudrun.service.TripLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripLogServiceImpl implements TripLogService {

    final TripLogMapper tripLogMapper;

    public TripLogServiceImpl(@Autowired TripLogMapper tripLogMapper) {
        this.tripLogMapper = tripLogMapper;
    }

    @Override
    public int insert(TripLog tripLog) {
        return tripLogMapper.insert(tripLog);
    }

    @Override
    public List<TripLog> findTopTripLogs() {
        return tripLogMapper.findTopTripLogs();
    }
}
