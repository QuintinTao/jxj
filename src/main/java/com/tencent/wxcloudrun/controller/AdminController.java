package com.tencent.wxcloudrun.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.AdminService;
import com.tencent.wxcloudrun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

/**
 * counter控制器
 */
@RestController

public class AdminController {

  final AdminService adminService;
  final Logger logger;

  public AdminController(@Autowired AdminService adminService) {
    this.adminService = adminService;
    this.logger = LoggerFactory.getLogger(CounterController.class);
  }


  /**
   * admin login
   * @return API response json
   */
  @GetMapping(value = "/api/login")
  @ResponseBody
  ApiResponse doLogin(String userName, String pass){
    logger.info("/api/doLogin" + userName + pass);
      boolean result = adminService.checkLogin(userName, pass);
      if(result) {
          return ApiResponse.ok();
      }
      return ApiResponse.error("管理员账号或密码错误！");
  }

//  @GetMapping(value = "/api/addUser")
//  ApiResponse addUser(String openid, Integer height, String weight,
//                      String sex, String hobby, String enjoyColor, String dressingStyle, String realName){
//      User user = new User();
//      user.setHeight(height);
//      user.setDressingStyle(dressingStyle);
//      user.setOpenid(openid);
//      user.setHobby(hobby);
//      user.setRealName(realName);
//      user.setEnjoyColor(enjoyColor);
//      user.setSex(sex);
//      user.setWeight(new BigDecimal(weight));
//      int result =  userService.insertOrUpdate(user);
//    return ApiResponse.ok(result);
//  }
//
//    @GetMapping(value = "/api/findUserByOpenId")
//    ApiResponse findUserByOpenId(String openid){
//        List<User> list =  userService.findUserByOpenId(openid);
//        return ApiResponse.ok(list);
//    }

  
}