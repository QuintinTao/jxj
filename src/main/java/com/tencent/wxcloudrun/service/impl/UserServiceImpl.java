package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final UserMapper userMapper;
    public UserServiceImpl(@Autowired UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int insertOrUpdate(User user) {
        List<User> list = userMapper.findUserByOpenId(user.getOpenid());
        if(list != null && list.size() > 0){
            if(null != user.getSession_key()){
                return userMapper.updateSessionKey(user);
            } else {
                return userMapper.update(user);
            }

        }

        return userMapper.insert(user);
    }
    public List<User> findUserByOpenId(String openid){
        return userMapper.findUserByOpenId(openid);
    }

}
