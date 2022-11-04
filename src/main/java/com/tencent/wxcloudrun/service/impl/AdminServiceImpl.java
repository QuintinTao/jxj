package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.AdminMapper;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.AdminService;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    final AdminMapper adminMapper;
    public AdminServiceImpl(@Autowired AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public boolean checkLogin(String userName, String pass) {
        List<Admin> admins = adminMapper.findUserByName(userName);
        if(admins != null && admins.size() > 0){
            Admin ad = admins.get(0);
            if(ad.getPass().equals(pass)){
                return true;
            }
        }
        return false;
    }
}
