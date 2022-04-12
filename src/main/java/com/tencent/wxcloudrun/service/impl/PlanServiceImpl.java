package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.PlanMapper;
import com.tencent.wxcloudrun.dao.ReviewMapper;
import com.tencent.wxcloudrun.model.Plan;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.service.PlanService;
import com.tencent.wxcloudrun.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    public static final String sb = "_";

    final PlanMapper planMapper;

    public PlanServiceImpl(@Autowired PlanMapper planMapper) {
        this.planMapper = planMapper;
    }


    @Override
    public int insert(Plan plan) {

       return planMapper.insert(plan);
    }
}
