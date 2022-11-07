package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BookListDto;
import com.tencent.wxcloudrun.dto.NonVehicleHisListDto;
import com.tencent.wxcloudrun.dto.NonVehicleListDto;
import com.tencent.wxcloudrun.model.Book;
import com.tencent.wxcloudrun.model.NonVehicle;
import com.tencent.wxcloudrun.model.NonVehicleHis;
import com.tencent.wxcloudrun.service.BookService;
import com.tencent.wxcloudrun.service.NonVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * counter控制器
 */
@RestController
public class NonVehicleController {

  final NonVehicleService nonVehicleService;
  final Logger logger;

  public NonVehicleController(@Autowired NonVehicleService nonVehicleService) {
    this.nonVehicleService = nonVehicleService;
    this.logger = LoggerFactory.getLogger(NonVehicleController.class);
  }


  @GetMapping(value = "/api/bindNonVehicle")
  ApiResponse unbind(
          String name,
          String novNum,
          String sno,
          String dept,
          String startTimeStr
) {
    logger.info("/api/bindNonVehicle");
    NonVehicle nv = new NonVehicle();
    nv.setDept(dept);
    nv.setName(name);
    nv.setSno(sno);
    nv.setNovNum(novNum);
    nv.setStarTime(toDate(startTimeStr));
      int result = nonVehicleService.bindNonVehicle(nv);
      if (result == 0){
          return ApiResponse.error("绑定失败！车辆已与其他用户绑定！");
      }
    return ApiResponse.ok(result);
  }
    @GetMapping(value = "/api/unBindNonVehicle")
    ApiResponse get(
            String id, String pass
    ) {
        logger.info("/api/unBindNonVehicle" + id + pass);
        if(!StringUtils.isEmpty(id)) {
            Integer idd = Integer.parseInt(id);
            NonVehicle nv = new NonVehicle();
            nv.setPass(pass);
            nv.setId(idd);
           int result = nonVehicleService.unbindNonVehicle(nv);
           if(result == 2)  return ApiResponse.ok();
           if(result == 1)  return ApiResponse.error("密码不正确！");
        }
        return ApiResponse.error("密码不正确！");
    }

    @GetMapping(value = "/api/findNonVehicleByNum")
    ApiResponse findNonVehicleByNum(String novNum) {
        logger.info("/api/findNonVehicleByNum  -" + novNum);
        List<NonVehicle> result = nonVehicleService.findNonVehicleByNum(novNum);
        NonVehicleListDto dto = new NonVehicleListDto();
        dto.setNonVehicles(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }

    @GetMapping(value = "/api/findHis")
    ApiResponse findHis(String novNum) {
        logger.info("/api/findHis  -" + novNum);
        List<NonVehicleHis> result = nonVehicleService.findHis(novNum);
        NonVehicleHisListDto dto = new NonVehicleHisListDto();
        dto.setNonVehicleHis(result);
        dto.setCount(result.size());
        return ApiResponse.ok(dto);
    }
    private Timestamp toDate(String dateString) {
        Date date = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateString);
            return new Timestamp(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}