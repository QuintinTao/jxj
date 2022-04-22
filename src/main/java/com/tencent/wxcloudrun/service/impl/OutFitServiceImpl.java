package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.OutFitMapper;
import com.tencent.wxcloudrun.dao.RatingMapper;
import com.tencent.wxcloudrun.model.OutFit;
import com.tencent.wxcloudrun.model.Rating;
import com.tencent.wxcloudrun.service.OutFitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OutFitServiceImpl implements OutFitService {
    final Logger logger = LoggerFactory.getLogger(OutFitServiceImpl.class);
    final OutFitMapper outFitMapper;
    final RatingMapper ratingMapper;

    public OutFitServiceImpl(@Autowired OutFitMapper outFitMapper,
                             @Autowired RatingMapper ratingMapper) {
        this.outFitMapper = outFitMapper;
        this.ratingMapper = ratingMapper;
    }
    @Override
    public List<OutFit> findOutFitsByUID(Integer uid) {
        return outFitMapper.findOutFitsByUId(uid);
    }

    @Override
    public int addOutFit(OutFit ot) {
        //sepera
        String pids = ot.getPid();
        String pics = ot.getPicUrl();
        String[] pidArray = pids.split(",");
        for(int i = 0; i < pidArray.length; i ++){
            Rating r = new Rating();
            r.setPid(Integer.parseInt(pidArray[i]));
            r.setScore(ot.getScore());
            r.setUid(ot.getUid());
            int count = ratingMapper.insert(r);
            logger.info("rating ->" + count);
        }
        return outFitMapper.insert(ot);
    }
}
