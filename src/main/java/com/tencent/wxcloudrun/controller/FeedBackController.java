package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.FeedBackListDto;
import com.tencent.wxcloudrun.model.FeedBack;
import com.tencent.wxcloudrun.model.Plan;
import com.tencent.wxcloudrun.service.FeedBackService;
import com.tencent.wxcloudrun.service.PlanService;
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
public class FeedBackController {

    final FeedBackService feedBackService;
    final Logger logger;

    public FeedBackController(@Autowired FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
        this.logger = LoggerFactory.getLogger(FeedBackController.class);
    }

    @GetMapping(value = "/api/addFeedBack")
    ApiResponse addPlan(String feedback, String question, String nickName) {
        logger.info("/api/addFeedBack feedback:" + feedback + "question:" + question);
        FeedBack p = new FeedBack();
        p.setFeedback(feedback);
        p.setQuestion(question);
        p.setfTime(new Timestamp(new Date().getTime()));
        return ApiResponse.ok(feedBackService.insert(p));
    }

    @GetMapping(value = "/api/getFeedBackList")
    ApiResponse getFeedBackList() {
        logger.info("/api/getFeedBackList feedback:");
        List<FeedBack> feedbacks = feedBackService.findFeedBackList();
        FeedBackListDto p = new FeedBackListDto();
        p.setFeedBacks(feedbacks);
        p.setCount(feedbacks.size());
        return ApiResponse.ok(p);
    }

}
