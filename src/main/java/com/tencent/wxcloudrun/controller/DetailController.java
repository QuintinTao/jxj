package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.DetailListDto;
import com.tencent.wxcloudrun.dto.ItemListDto;
import com.tencent.wxcloudrun.model.Detail;
import com.tencent.wxcloudrun.model.Item;
import com.tencent.wxcloudrun.service.DetailService;
import com.tencent.wxcloudrun.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DetailController {

    final DetailService detailService;
    final Logger logger;

    public DetailController(@Autowired DetailService detailService) {
        this.detailService = detailService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 获取当前计数
     * @return API response json
     */
    @GetMapping(value = "/api/findDetailByItemId")
    ApiResponse get(Integer itemId) {
        logger.info("/api/get all details with itemId" + itemId);
        List<Detail> result = detailService.findDetailByItemId(itemId);
        DetailListDto dto = new DetailListDto();
        dto.setDetails(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }

    /**
     * 获取当前计数
     * @return API response json
     */
    @GetMapping(value = "/api/getReviewItems")
    ApiResponse getReviewItems(Integer itemId, Integer familiar) {
        logger.info("/api/get all reviewItems with itemId" + itemId);
        List<Detail> result = detailService.findReviewDetailByItemId(itemId, familiar);
        DetailListDto dto = new DetailListDto();
        dto.setDetails(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }


}
