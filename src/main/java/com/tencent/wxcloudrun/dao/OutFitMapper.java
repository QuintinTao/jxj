package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.OutFit;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OutFitMapper {

    List<OutFit> findOutFitsByUId(Integer uid);

    int insert(OutFit ot);

}
