package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.model.OutFit;

import java.util.List;

public interface OutFitService {

    List<OutFit> findOutFitsByUID(Integer uid);

    int addOutFit(OutFit ot);
}
