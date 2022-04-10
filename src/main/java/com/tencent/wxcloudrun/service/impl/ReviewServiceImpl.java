package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ReviewMapper;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    final ReviewMapper reviewMapper;

    public ReviewServiceImpl(@Autowired ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    public List<Review> findReviewByBookId(Integer bookId, Integer userId){
        Review review = new com.tencent.wxcloudrun.model.Review();
        review.setBookId(bookId);
        review.setUserId(userId);
        return reviewMapper.findReviewByBookId(review);
    }

}
