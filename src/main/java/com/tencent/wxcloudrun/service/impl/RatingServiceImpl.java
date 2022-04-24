package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.PicMapper;
import com.tencent.wxcloudrun.dao.RatingMapper;
import com.tencent.wxcloudrun.model.Pic;
import com.tencent.wxcloudrun.model.Rating;
import com.tencent.wxcloudrun.service.RatingService;
import com.tencent.wxcloudrun.utils.CoreMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.activation.FileDataSource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    final RatingMapper ratingMapper;

    final PicMapper picMapper;

    public RatingServiceImpl(@Autowired RatingMapper ratingMapper,
    @Autowired PicMapper picMapper) {
        this.ratingMapper = ratingMapper;
        this.picMapper = picMapper;
    }
    @Override
    public List<Rating> findAll() {
        return ratingMapper.findAll();
    }

    @Override
    public List<Pic> gUserLike(Integer uid) {
        CoreMath coreMath = new CoreMath();
        List<Rating> ratings = ratingMapper.findAll();
        List<Integer> recommendations = coreMath.recommend(uid, ratings);
        List<Pic> pics = picMapper.findAll4Train();
        List<Pic> itemList= pics.stream().filter(e -> recommendations.contains(e.getId())).collect(Collectors.toList());
        return itemList;
    }
}
