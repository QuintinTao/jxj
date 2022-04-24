package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Pic;

import java.util.List;

public interface PicService {

    List<Pic> findPicByCid(Integer cid);

    List<Pic> findTopSimPic(Integer id);

    List<Pic> findAll4List(Integer uid);

    int insertOrUpdate(Pic p);

    int insertBatch(List<Pic> pics);
}
