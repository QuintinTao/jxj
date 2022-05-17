package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.TripListDto;
import com.tencent.wxcloudrun.dto.TripLogListDto;
import com.tencent.wxcloudrun.model.Trip;
import com.tencent.wxcloudrun.model.TripLog;
import com.tencent.wxcloudrun.service.TripLogService;
import com.tencent.wxcloudrun.service.TripService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class TripController {

    final TripService tripService;
    final Logger logger;

    public TripController(@Autowired TripService tripService) {
        this.tripService = tripService;
        this.logger = LoggerFactory.getLogger(TripController.class);
    }

    /**
     *  行程
     */
    @GetMapping(value = "/api/startTrip")
    ApiResponse startTrip(String startGps) {
        logger.info("/api/startTrip startGps:" + startGps);
        if(null == startGps){
            return ApiResponse.error("信息不足！");
        }
        Trip p = new Trip();
        p.setStartGps(startGps);
        p.setStartTime(new Timestamp(new Date().getTime()));
        return ApiResponse.ok(tripService.insert(p));
    }

    @GetMapping(value = "/api/endTrip")
    ApiResponse endTrip(String endGps, String cost, Integer tripId) {
        logger.info("/api/endTrip endGps:" + endGps + "cost:" + cost);
        if(null == endGps){
            return ApiResponse.error("信息不足！");
        }
        Trip p = new Trip();
        p.setId(tripId);
        p.setEndGps(endGps);
        p.setCost(new BigDecimal(cost));
        p.setEndTime(new Timestamp(new Date().getTime()));
        return ApiResponse.ok(tripService.update(p));
    }

    @GetMapping(value = "/api/findTopTrips")
    ApiResponse findTopTrips(){
        logger.info("/api/findTopTripLogs");
        TripListDto p = new TripListDto();
        List<Trip> log = tripService.findTopTrips();
        p.setTrips(log);
        p.setCount(log.size());
        return ApiResponse.ok(p);
    }

}
