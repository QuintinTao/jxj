package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.TripLogListDto;
import com.tencent.wxcloudrun.model.Plan;
import com.tencent.wxcloudrun.model.TripLog;
import com.tencent.wxcloudrun.service.PlanService;
import com.tencent.wxcloudrun.service.TripLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class TripLogController {

    final TripLogService tripLogService;
    final Logger logger;

    public TripLogController(@Autowired TripLogService tripLogService) {
        this.tripLogService = tripLogService;
        this.logger = LoggerFactory.getLogger(TripLogController.class);
    }

    /**
     * 插入日志
     */
    @GetMapping(value = "/api/addTripLog")
    ApiResponse addPlan(String startGps, String endGps, String tripName,String startName, String endName) {
        logger.info("/api/addTripLog startGps:" + startGps + "endGps:" + endGps + ",tripName:" + tripName+ ",endName:" + endName+ ",startName:" + startName);
        if(null == tripName || null == startGps || null == endGps){
            return ApiResponse.error("信息不足！");
        }
        TripLog p = new TripLog();
        p.setTripName(tripName);
        p.setStartGps(startGps);
        p.setStartName(startName);
        p.setEndName(endName);
        p.setEndGps(endGps);
        p.setTripTime(new Timestamp(new Date().getTime()));
        return ApiResponse.ok(tripLogService.insert(p));
    }


    /**
     * 插入日志
     */
    @GetMapping(value = "/api/findTopTripLogs")
    ApiResponse findTopTripLogs(){
        logger.info("/api/findTopTripLogs");
        TripLogListDto p = new TripLogListDto();
        List<TripLog> log = tripLogService.findTopTripLogs();
        p.setLogs(log);
        p.setCount(log.size());
        return ApiResponse.ok(p);
    }

}
