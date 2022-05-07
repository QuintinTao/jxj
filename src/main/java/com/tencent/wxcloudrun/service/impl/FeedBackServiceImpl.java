package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.FeedBackMapper;
import com.tencent.wxcloudrun.dao.PlanMapper;
import com.tencent.wxcloudrun.model.FeedBack;
import com.tencent.wxcloudrun.model.Plan;
import com.tencent.wxcloudrun.service.FeedBackService;
import com.tencent.wxcloudrun.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    public static final String sb = "_";

     final FeedBackMapper feedBackMapper;

    public FeedBackServiceImpl(@Autowired FeedBackMapper feedBackMapper) {
        this.feedBackMapper = feedBackMapper;
    }


    @Override
    public int insert(FeedBack fb) {

       return feedBackMapper.insert(fb);
    }

    @Override
    public List<FeedBack> findFeedBackList() {
        return feedBackMapper.findFeedBackList();
    }
}
