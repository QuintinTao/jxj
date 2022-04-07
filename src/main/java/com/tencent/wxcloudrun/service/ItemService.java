package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> findItemsByBookId(Integer bookId);

}
