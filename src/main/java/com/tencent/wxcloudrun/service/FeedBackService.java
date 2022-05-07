package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.FeedBack;

import java.util.List;

public interface FeedBackService {

    int insert(FeedBack fb);

    List<FeedBack> findFeedBackList();
}
