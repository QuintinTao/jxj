package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Pic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PicMapper {

    List<Pic> findPicByCid(Integer cid);

}
