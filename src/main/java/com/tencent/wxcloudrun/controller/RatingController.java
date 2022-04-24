package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.PicListDto;
import com.tencent.wxcloudrun.model.Pic;
import com.tencent.wxcloudrun.service.RatingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingController {

    final RatingService ratingService;
    final Logger logger;

    public RatingController(@Autowired RatingService ratingService) {
        this.ratingService = ratingService;
        this.logger = LoggerFactory.getLogger(RatingController.class);
    }

    @GetMapping(value = "/api/findRecommends")
    ApiResponse findRecommends(Integer uid) {
        logger.info("/api/findRecommends uid:" + uid);
        List<Pic> list = ratingService.gUserLike(uid);
        PicListDto dto = new PicListDto();
        dto.setPics(list);
        dto.setCount(list.size());
        return ApiResponse.ok(dto);
    }


}
