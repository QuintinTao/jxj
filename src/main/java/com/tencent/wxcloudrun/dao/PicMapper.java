package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Pic;
import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PicMapper {

    List<Pic> findPicByCid(Integer cid);

    List<Pic> findPicById(Integer id);

    List<Pic> findAll4Train();

    List<Pic> findAll4List(Integer uid);

    int insert(Pic p);

    int update(Pic p);


}
