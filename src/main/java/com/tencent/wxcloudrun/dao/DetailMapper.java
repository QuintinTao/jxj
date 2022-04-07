package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Book;
import com.tencent.wxcloudrun.model.Detail;
import com.tencent.wxcloudrun.model.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {

    List<Detail> findDetailByItemId(Integer itemId);
}
