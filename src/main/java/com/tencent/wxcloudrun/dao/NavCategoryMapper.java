package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.ext.NavCategoryExt;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface NavCategoryMapper {


    List<NavCategoryExt> findAllNavPoints();

}
