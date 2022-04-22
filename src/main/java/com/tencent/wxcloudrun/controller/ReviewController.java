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
    ApiResponse findReviewByBookId(Integer userId, Integer familiar, Integer start) {
        logger.info("/api/findReviewByBookId userId:" + userId + ",familiar:" + familiar + "start："  + start);
        List<Review> result = reviewService.findReviewByTime(familiar,start);
        ReviewListDto dto = new ReviewListDto();
        dto.setReviews(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }

    /**
     * 根据book 获取Reviwe内容
     * @return API response json
     */
    @GetMapping(value = "/api/addReview")
    ApiResponse get(Integer bookId, Integer userId, String content) {
        logger.info("/api/addReview bookId:" + bookId + "userId:" + userId + ",content:" + content);
        Review r = new Review();
        r.setUserId(userId);
        r.setBookId(bookId);
        r.setContent(content);
        int result = reviewService.addReviewItems(r);
        return ApiResponse.ok(result);
    }

    /**
     * 根据book 提交学习，插入复习
     * @return API response json
     */
    @GetMapping(value = "/api/submitStudy")
    ApiResponse get(Integer itemId, Integer userId) {
        logger.info("/api/submitStudy itemId:" + itemId + "userId:" + userId);
        int result = reviewService.findItemDetailAndCopy(itemId, userId);
        return ApiResponse.ok(result);
    }

}
