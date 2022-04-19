package com.tencent.wxcloudrun.config;

import lombok.Data;

import java.util.HashMap;

@Data
public final class ApiResponse {

  private Integer code;
  private String msg;
  private Object data;
  private Integer count = 100;

  private ApiResponse(int code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }
  
  public static ApiResponse ok() {
    return new ApiResponse(0, "", new HashMap<>());
  }

  public static ApiResponse ok(Object data) {
    return new ApiResponse(0, "", data);
  }

  public static ApiResponse error(String errorMsg) {
    return new ApiResponse(0, errorMsg, new HashMap<>());
  }
}
