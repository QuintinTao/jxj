package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Pic;
import com.tencent.wxcloudrun.model.Rating;
import java.util.List;


public interface RatingService {

    List<Rating> findAll();

    List<Pic> gUserLike(Integer uid);

}
