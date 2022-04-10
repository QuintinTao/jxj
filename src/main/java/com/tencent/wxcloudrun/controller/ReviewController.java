package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.ItemListDto;
import com.tencent.wxcloudrun.dto.ReviewListDto;
import com.tencent.wxcloudrun.model.Item;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.service.ItemService;
import com.tencent.wxcloudrun.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    final ReviewService reviewService;
    final Logger logger;

    public ReviewController(@Autowired ReviewService reviewService) {
        this.reviewService = reviewService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 根据book 获取Reviwe内容
     * @return API response json
     */
    @GetMapping(value = "/api/findReviewByBookId")
    ApiResponse get(Integer bookId, Integer userId, Integer familiar) {
        logger.info("/api/findReviewByBookId bookId:" + bookId + "userId:" + userId + ",familiar:" + familiar);
        List<Review> result = reviewService.findReviewByBookId(bookId, userId, familiar);
        ReviewListDto dto = new ReviewListDto();
        dto.setReviews(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }

}
