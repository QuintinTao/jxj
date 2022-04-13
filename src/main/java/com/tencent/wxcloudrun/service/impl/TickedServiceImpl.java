package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ReviewMapper;
import com.tencent.wxcloudrun.dao.TickedMapper;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.model.Ticked;
import com.tencent.wxcloudrun.service.ReviewService;
import com.tencent.wxcloudrun.service.TickedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickedServiceImpl implements TickedService {

    public static final String sb = "_";

    final TickedMapper tickedMapper;

    public TickedServiceImpl(@Autowired TickedMapper tickedMapper) {
        this.tickedMapper = tickedMapper;
    }


    @Override
    public int insert(Ticked ticked) {
        return tickedMapper.insert(ticked);
    }

    @Override
    public List<Ticked> findTodayTicked() {
        return tickedMapper.findTodayTicked();
    }

    @Override
    public List<Ticked> findTickedByUserId(Integer userId) {
        return tickedMapper.findTickedByUserId(userId);
    }
}
