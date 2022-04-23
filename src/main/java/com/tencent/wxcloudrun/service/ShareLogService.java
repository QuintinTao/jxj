package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ShareLog;
import java.util.List;

public interface ShareLogService {

    int insert(ShareLog shareLog);

    List<ShareLog> findTopShareLogs();
}
