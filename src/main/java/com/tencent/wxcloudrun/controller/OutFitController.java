package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.OutFitListDto;
import com.tencent.wxcloudrun.dto.ReviewListDto;
import com.tencent.wxcloudrun.model.OutFit;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.service.OutFitService;
import com.tencent.wxcloudrun.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OutFitController {

    final OutFitService outFitService;
    final Logger logger;

    public OutFitController(@Autowired OutFitService outFitService) {
        this.outFitService = outFitService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }


    @GetMapping(value = "/api/findOutFitById")
    ApiResponse findOutFitById(Integer userId) {
        logger.info("/api/findOutFitById userId:" + userId);
        List<OutFit> result = outFitService.findOutFitsByUID(userId);
        OutFitListDto dto = new OutFitListDto();
        dto.setOutFits(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }


    @GetMapping(value = "/api/addOutFit")
    ApiResponse addOutFit(Integer userId, String pid,String title, String score, String picUrl) {
        logger.info("/api/addOutFit userId:" + userId);
        OutFit out = new OutFit();
        out.setPid(pid);
        out.setTitle(title);
        out.setPicUrl(picUrl);
        out.setScore(Float.parseFloat(score));
        out.setUid(userId);
        int count = outFitService.addOutFit(out);
        return ApiResponse.ok(count);
    }


}
