package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.NavPoint;
import com.tencent.wxcloudrun.model.User;

import java.util.List;

public interface UserService {

    Integer insertOrUpdate(User user);

    List<User> findUserByOpenId(String openid);
}
