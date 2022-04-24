package com.tencent.wxcloudrun.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.PicListDto;
import com.tencent.wxcloudrun.dto.TickedListDto;
import com.tencent.wxcloudrun.model.Pic;
import com.tencent.wxcloudrun.model.Ticked;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.PicService;
import com.tencent.wxcloudrun.service.TickedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PicController {

    final PicService picService;
    final Logger logger;

    public PicController(@Autowired PicService picService) {
        this.picService = picService;
        this.logger = LoggerFactory.getLogger(PicController.class);
    }

    @GetMapping(value = "/api/findPicByCid")
    ApiResponse findPicByCid(Integer cid) {
        logger.info("/api/findPicByCid cid:" + cid);
        List<Pic> list = picService.findPicByCid(cid);
        PicListDto dto = new PicListDto();
        dto.setPics(list);
        dto.setCount(list.size());
        return ApiResponse.ok(dto);
    }

    @GetMapping(value = "/api/findTopSimPic")
//    @Scheduled(cron = "0/5 * * * * ?")
    ApiResponse findTopSimPic(Integer id) {
        logger.info("/api/findTopSimPic id:" + id);
        List<Pic> list = picService.findTopSimPic(id);
        PicListDto dto = new PicListDto();
        dto.setPics(list);
        dto.setCount(list.size());
        return ApiResponse.ok(dto);
    }
    //[{"cid":1, "picUrl":"pic1","title":"aaa"},{"cid":1, "picUrl":"pic2","title":"bbb"},{"cid":1, "picUrl":"pic3","title":"ccc"}]
    @GetMapping(value = "/api/addPic")
    ApiResponse addPic(String json) {
       // json = "[{\"cid\":1, \"picUrl\":\"pic1\"},{\"cid\":1, \"picUrl\":\"pic2\"},{\"cid\":1, \"picUrl\":\"pic3\"}]";
        logger.info("/api/addPic json:" + json);
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Pic> pics = mapper.readValue(json, new TypeReference<List<Pic>>() {});
            picService.insertBatch(pics);
        } catch (Exception e) {
            logger.error("addPic",  e);
        }
        return ApiResponse.ok(1);
    }
    //todo
    @GetMapping(value = "/api/findAllMyPics")
    ApiResponse findAllMyPics(Integer uid) {
        logger.info("/api/findAllMyPics uid:" + uid);
        List<Pic> list = picService.findAll4List(uid);
        PicListDto dto = new PicListDto();
        dto.setPics(list);
        dto.setCount(list.size());
        return ApiResponse.ok(dto);
    }

}
