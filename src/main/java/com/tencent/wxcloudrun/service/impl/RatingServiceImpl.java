package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.RatingMapper;
import com.tencent.wxcloudrun.model.Rating;
import com.tencent.wxcloudrun.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    final RatingMapper ratingMapper;

    public RatingServiceImpl(@Autowired RatingMapper ratingMapper) {
        this.ratingMapper = ratingMapper;
    }
    @Override
    public List<Rating> findAll() {
        return ratingMapper.findAll();
    }
}
