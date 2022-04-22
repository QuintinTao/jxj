package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Pic;

import java.util.List;

public interface PicService {

    List<Pic> findPicByCid(Integer cid);

    List<Pic> findTopSimPic(Integer id);

    int insertOrUpdate(Pic p);

    int insertBatch(List<Pic> pics);
}
