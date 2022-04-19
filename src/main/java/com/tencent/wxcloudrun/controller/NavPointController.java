package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.NavCategoryExtListDto;
import com.tencent.wxcloudrun.dto.NavPointsListDto;
import com.tencent.wxcloudrun.model.NavPoint;
import com.tencent.wxcloudrun.model.ext.NavCategoryExt;
import com.tencent.wxcloudrun.service.NavCategoryService;
import com.tencent.wxcloudrun.service.NavPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class NavPointController {

    final NavPointService navPointService;
    final Logger logger;

    public NavPointController(@Autowired NavPointService navPointService) {
        this.navPointService = navPointService;
        this.logger = LoggerFactory.getLogger(NavPointController.class);
    }

    @GetMapping("/es/import")
    public ModelAndView menu(){
        return new ModelAndView("tools/es/import");
    }

    @PostMapping("/es/impData")
    public ApiResponse impData(NavPoint navPoint) throws Exception {
        logger.info("NavPoint" + navPoint.toString());
        int result =  navPointService.insert(navPoint);
        return ApiResponse.ok(result);
    }

    @GetMapping("/es/list")
    public ModelAndView list(){
        return new ModelAndView("sys/authority/authority");
    }

    @GetMapping(value = "/api/findNavPoints")
    ApiResponse findAllNavPoints() {
        logger.info("/api/findNavPoints");
        List<NavPoint> result = navPointService.findAllNavPoints();
        NavPointsListDto dto = new NavPointsListDto();
        dto.setPoints(result);
        dto.setCount(result.size());
        return ApiResponse.ok(result);
    }

}
