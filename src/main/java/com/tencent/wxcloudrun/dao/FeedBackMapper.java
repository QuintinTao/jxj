package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.FeedBack;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface FeedBackMapper {

    int insert(FeedBack fb);
}
