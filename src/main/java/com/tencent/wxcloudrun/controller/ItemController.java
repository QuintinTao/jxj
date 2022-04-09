package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BookListDto;
import com.tencent.wxcloudrun.dto.ItemListDto;
import com.tencent.wxcloudrun.model.Book;
import com.tencent.wxcloudrun.model.Item;
import com.tencent.wxcloudrun.service.BookService;
import com.tencent.wxcloudrun.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    final ItemService itemService;
    final Logger logger;

    public ItemController(@Autowired ItemService itemService) {
        this.itemService = itemService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 获取当前计数
     * @return API response json
     */
    @GetMapping(value = "/api/findItemsByBookId")
    ApiResponse get(Integer bookId) {
        logger.info("/api/get all Items by bookId" + bookId);
        List<Item> result = itemService.findItemsByBookId(bookId);
        ItemListDto dto = new ItemListDto();
        dto.setItems(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }

}
