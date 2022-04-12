package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ReviewListDto;
import com.tencent.wxcloudrun.model.Plan;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.service.PlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlanController {

    final PlanService planService;
    final Logger logger;

    public PlanController(@Autowired PlanService planService) {
        this.planService = planService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 根据book 获取Reviwe内容
     * @return API response json
     */
    @PostMapping(value = "/api/addPlan")
    ApiResponse addPlan(String startTime, Integer userId, String endTime, String token) {
        logger.info("/api/findReviewByBookId startTime:" + startTime + "userId:" + userId + ",endTime:" + endTime);
        if(token == null || !token.equals("29thd03")){
            return ApiResponse.error("刷新token");
        }
        Plan p = new Plan();
        p.setUserId(userId);
        p.setStartTime(startTime);
        p.setEndTime(endTime);
        return ApiResponse.ok(planService.insert(p));
    }

}
