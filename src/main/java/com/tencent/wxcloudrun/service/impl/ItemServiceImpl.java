package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.ItemMapper;
import com.tencent.wxcloudrun.model.Item;
import com.tencent.wxcloudrun.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    final ItemMapper itemMapper;

    public ItemServiceImpl(@Autowired ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public List<Item> findItemsByBookId(Integer bookId){
        return itemMapper.findItemsByBookId(bookId);
    }

}
