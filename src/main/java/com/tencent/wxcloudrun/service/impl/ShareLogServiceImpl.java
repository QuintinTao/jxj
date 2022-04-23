package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ShareLogMapper;
import com.tencent.wxcloudrun.model.ShareLog;
import com.tencent.wxcloudrun.service.ShareLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareLogServiceImpl implements ShareLogService {

    final ShareLogMapper shareLogMapper;

    public ShareLogServiceImpl(@Autowired ShareLogMapper shareLogMapper) {
        this.shareLogMapper = shareLogMapper;
    }

    @Override
    public int insert(ShareLog shareLog) {
        return shareLogMapper.insert(shareLog);
    }

    @Override
    public List<ShareLog> findTopShareLogs() {
        return shareLogMapper.findTopShareLogs();
    }
}
