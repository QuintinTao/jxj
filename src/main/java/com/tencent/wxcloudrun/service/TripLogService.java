package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.model.TripLog;

import java.util.List;

public interface TripLogService {
    int insert(TripLog tripLog);

    List<TripLog> findTopTripLogs();
}
