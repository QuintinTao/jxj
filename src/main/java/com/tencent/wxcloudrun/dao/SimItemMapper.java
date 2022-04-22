package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.SimItem;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SimItemMapper {

    int insert(SimItem simItem);

}
