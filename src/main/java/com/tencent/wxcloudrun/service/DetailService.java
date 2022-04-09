package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Detail;

import java.util.List;

public interface DetailService {

    List<Detail> findDetailByItemId(Integer itemId);


    List<Detail> findReviewDetailByItemId(Integer itemId, int familiar);
}
