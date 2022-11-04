package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> findUserByName(String userName);

}
