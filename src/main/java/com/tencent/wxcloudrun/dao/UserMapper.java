package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User Ticked);

    int update(User Ticked);

    int updateSessionKey(User user);

    List<User> findUserByOpenId(String openid);

}
