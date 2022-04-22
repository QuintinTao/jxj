package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findReviewByBookId(Integer bookId, Integer userId, Integer familiar);
    int addReviewItems(Review review);
    List<Review> findReviewByTime(Integer familiar,Integer start);
    int findItemDetailAndCopy(Integer itemId,Integer UserId);
}
