package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Ticked;

import java.util.List;

public interface TickedService {

    int insert(Ticked ticked);

    List<Ticked> findTodayTicked();

    List<Ticked> findTickedByUserId(Integer userId);
}
