package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.ShareLog;
import com.tencent.wxcloudrun.model.TripLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ShareLogMapper {

    int insert(ShareLog shareLog);

    List<ShareLog> findTopShareLogs();
}
