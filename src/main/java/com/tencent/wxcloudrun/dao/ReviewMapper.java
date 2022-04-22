package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    List<Review> findReviewByBookId(Review review);


    int insert(Review review);


    List<Review> findReviewByTime(Integer start);
}
