package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ShareLogListDto;
import com.tencent.wxcloudrun.model.ShareLog;
import com.tencent.wxcloudrun.service.ShareLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class ShareLogController {

    final ShareLogService shareLogService;
    final Logger logger;

    public ShareLogController(@Autowired ShareLogService shareLogService) {
        this.shareLogService = shareLogService;
        this.logger = LoggerFactory.getLogger(ShareLogController.class);
    }

    /**
     * 插入日志
     */
    @GetMapping(value = "/api/addShareLog")
    ApiResponse addShareLog(String fromStr) {
        logger.info("/api/addTripLog fromStr:" + fromStr);
        if(null == fromStr){
            return ApiResponse.error("信息不足！");
        }
        ShareLog p = new ShareLog();
        p.setFromStr(fromStr);
        p.setShareTime(new Timestamp(new Date().getTime()));
        return ApiResponse.ok(shareLogService.insert(p));
    }


    /**
     * 插入日志
     */
    @GetMapping(value = "/api/findTopShareLogs")
    ApiResponse findTopTripLogs(){
        logger.info("/api/findTopShareLogs");
        ShareLogListDto p = new ShareLogListDto();
        List<ShareLog> log = shareLogService.findTopShareLogs();
        p.setLogs(log);
        p.setCount(log.size());
        return ApiResponse.ok(p);
    }

}
