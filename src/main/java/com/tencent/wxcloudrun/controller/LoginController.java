package com.tencent.wxcloudrun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BookListDto;
import com.tencent.wxcloudrun.model.Book;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.BookService;
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

public class LoginController {

  final RestTemplate restTemplate;
  final UserService userService;
  final Logger logger;

  public LoginController(@Autowired UserService userService, @Autowired RestTemplate restTemplate) {
    this.userService = userService;
    this.restTemplate = restTemplate;
    this.logger = LoggerFactory.getLogger(CounterController.class);
  }


  /**
   * 获取当前计数
   * @return API response json
   */
  @GetMapping(value = "/api/doLogin")
  @ResponseBody
  ApiResponse doLogin(String js_code){
    logger.info("/api/doLogin" + js_code);
    int count = 0;
    String wxServer = "https://api.weixin.qq.com/sns/jscode2session?appid=wxbd7344e4c63064bb&secret=398312c98aa75c6d418e5e9716957e76&js_code="+js_code+"&grant_type=authorization_code";
    logger.info("/api/doLogin" + wxServer);
    String result = restTemplate.getForObject(wxServer,String.class);
    ObjectMapper mapper = new ObjectMapper();
    User user = null;
    try {
      user = mapper.readValue(result, User.class);
      count = userService.insertOrUpdate(user);
      if(count > 0) {
          return ApiResponse.ok(user);
      }
    } catch (Exception e) {
      logger.error("doLogin ::",  e);
      return ApiResponse.error(e.getMessage());
    }
    return ApiResponse.error("error");
  }

  @GetMapping(value = "/api/addUser")
  ApiResponse addUser(String openid, Integer height, String weight,
                      String sex, String hobby, String enjoyColor, String dressingStyle, String realName){
      User user = new User();
      user.setHeight(height);
      user.setDressingStyle(dressingStyle);
      user.setOpenid(openid);
      user.setHobby(hobby);
      user.setRealName(realName);
      user.setEnjoyColor(enjoyColor);
      user.setSex(sex);
      user.setWeight(new BigDecimal(weight));
      int result =  userService.insertOrUpdate(user);
    return ApiResponse.ok(result);
  }

    @GetMapping(value = "/api/findUserByOpenId")
    ApiResponse findUserByOpenId(String openid){
        List<User> list =  userService.findUserByOpenId(openid);
        return ApiResponse.ok(list);
    }


//  /**
//   * 更新计数，自增或者清零
//   * @param request {@link CounterRequest}
//   * @return API response json
//   */
//  @PostMapping(value = "/api/count")
//  ApiResponse create(@RequestBody CounterRequest request) {
//    logger.info("/api/count post request, action: {}", request.getAction());
//
//    Optional<Counter> curCounter = counterService.getCounter(1);
//    if (request.getAction().equals("inc")) {
//      Integer count = 1;
//      if (curCounter.isPresent()) {
//        count += curCounter.get().getCount();
//      }
//      Counter counter = new Counter();
//      counter.setId(1);
//      counter.setCount(count);
//      counterService.upsertCount(counter);
//      return ApiResponse.ok(count);
//    } else if (request.getAction().equals("clear")) {
//      if (!curCounter.isPresent()) {
//        return ApiResponse.ok(0);
//      }
//      counterService.clearCount(1);
//      return ApiResponse.ok(0);
//    } else {
//      return ApiResponse.error("参数action错误");
//    }
//  }
  
}