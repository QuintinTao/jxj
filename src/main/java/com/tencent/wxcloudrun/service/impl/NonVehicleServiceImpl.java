package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.controller.NonVehicleController;
import com.tencent.wxcloudrun.dao.NonVehicleHisMapper;
import com.tencent.wxcloudrun.dao.NonVehicleMapper;
import com.tencent.wxcloudrun.model.NonVehicle;
import com.tencent.wxcloudrun.model.NonVehicleHis;
import com.tencent.wxcloudrun.service.NonVehicleService;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NonVehicleServiceImpl implements NonVehicleService {

    final NonVehicleMapper nonVehicleMapper;
    final NonVehicleHisMapper nonVehicleHisMapper;
    final Logger logger;

    public NonVehicleServiceImpl(@Autowired NonVehicleMapper nonVehicleMapper, @Autowired NonVehicleHisMapper nonVehicleHisMapper) {
        this.nonVehicleMapper = nonVehicleMapper;
        this.nonVehicleHisMapper = nonVehicleHisMapper;
        this.logger = LoggerFactory.getLogger(NonVehicleServiceImpl.class);
    }


    @Override
    public int bindNonVehicle(NonVehicle nonVehicle) {
        int num;
        try {
            num = nonVehicleMapper.insert(nonVehicle);
        } catch (Exception e) {
            logger.error("insert non vehicleMapper", e);
            return 0;
        }

        NonVehicleHis his = new NonVehicleHis();
        try {
            BeanUtils.copyProperties(his,nonVehicle);
        } catch (Exception e) {
            logger.error("bean copy error", e);
            return 0;
        }
        logger.info(nonVehicle.toString());
        if(num > 0) {
            nonVehicleHisMapper.insert(his);
            return nonVehicle.getId();
//            return 1;
        }
        return 0;
    }

    @Override
    public void unbindNonVehicle(NonVehicle nonVehicle) {
            nonVehicleMapper.deleteById(nonVehicle.getId());
    }

    @Override
    public List<NonVehicle> findNonVehicleByNum(String novNum) {
        return nonVehicleMapper.findNonVehicleByNum(novNum);
    }

    @Override
    public List<NonVehicleHis> findHis(String novNum) {
        return nonVehicleHisMapper.findHis(novNum);
    }
}
