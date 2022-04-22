package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ReviewListDto;
import com.tencent.wxcloudrun.dto.TickedListDto;
import com.tencent.wxcloudrun.model.Plan;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.model.Ticked;
import com.tencent.wxcloudrun.service.PlanService;
import com.tencent.wxcloudrun.service.TickedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TickedController {

    final TickedService tickedService;
    final Logger logger;

    public TickedController(@Autowired TickedService tickedService) {
        this.tickedService = tickedService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 根据book 获取Reviwe内容
     * @return API response json
     */
    @GetMapping(value = "/api/addTicked")
    ApiResponse addTicked(String tickedDate, Integer userId) {
        logger.info("/api/addTicked tickedDate:" + tickedDate + "userId:" + userId);
        List<Ticked> list = tickedService.findTodayTicked();
        if(list != null && list.size() > 0){
            return ApiResponse.ok(100);//已打卡
        }
        Ticked t = new Ticked();
        t.setUserId(userId);
        t.setTickedDate(tickedDate);
        return ApiResponse.ok(tickedService.insert(t));
    }

    @GetMapping(value = "/api/findTickedByUserId")
    ApiResponse get(Integer userId) {
        logger.info("/api/findTickedByUserId userId:" + userId );
        List<Ticked> result = tickedService.findTickedByUserId(userId);
        TickedListDto dto = new TickedListDto();
        dto.setTicks(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }

}
