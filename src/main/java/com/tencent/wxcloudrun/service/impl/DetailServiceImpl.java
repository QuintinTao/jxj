package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.BookMapper;
import com.tencent.wxcloudrun.dao.DetailMapper;
import com.tencent.wxcloudrun.dao.ItemMapper;
import com.tencent.wxcloudrun.model.Detail;
import com.tencent.wxcloudrun.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailServiceImpl implements DetailService {

    final DetailMapper detailMapper;

    public DetailServiceImpl(@Autowired DetailMapper detailMapper) {
        this.detailMapper = detailMapper;
    }

    public List<Detail> findDetailByItemId(Integer itemId){
        return detailMapper.findDetailByItemId(itemId);
    }
}
