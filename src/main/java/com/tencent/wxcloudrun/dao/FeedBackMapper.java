package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.FeedBack;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FeedBackMapper {

    int insert(FeedBack fb);


    List<FeedBack> findFeedBackList();
}
