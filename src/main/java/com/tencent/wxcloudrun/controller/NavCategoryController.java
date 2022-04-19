package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.NavCategoryExtListDto;
import com.tencent.wxcloudrun.dto.TickedListDto;
import com.tencent.wxcloudrun.model.NavPoint;
import com.tencent.wxcloudrun.model.Ticked;
import com.tencent.wxcloudrun.model.ext.NavCategoryExt;
import com.tencent.wxcloudrun.service.NavCategoryService;
import com.tencent.wxcloudrun.service.TickedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class NavCategoryController {

    final NavCategoryService navCategoryService;
    final Logger logger;

    public NavCategoryController(@Autowired NavCategoryService navCategoryService) {
        this.navCategoryService = navCategoryService;
        this.logger = LoggerFactory.getLogger(NavCategoryController.class);
    }

    @GetMapping(value = "/api/findAllNavPoints")
    ApiResponse findAllNavPoints() {
        logger.info("/api/findAllNavPoints");
        List<NavCategoryExt> result = navCategoryService.findAllNavPoints();
        NavCategoryExtListDto dto = new NavCategoryExtListDto();
        dto.setCategories(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }

}
