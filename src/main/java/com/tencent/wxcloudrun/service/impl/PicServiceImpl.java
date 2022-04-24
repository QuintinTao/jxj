package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.algorithm.CosHelper;
import com.tencent.wxcloudrun.dao.PicMapper;
import com.tencent.wxcloudrun.dao.SimItemMapper;
import com.tencent.wxcloudrun.dto.SimItemDto;
import com.tencent.wxcloudrun.model.Pic;
import com.tencent.wxcloudrun.model.SimItem;
import com.tencent.wxcloudrun.service.PicService;
import com.tencent.wxcloudrun.utils.CompareUtils;
import com.tencent.wxcloudrun.utils.RecUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PicServiceImpl implements PicService {

    final PicMapper picMapper;

    final SimItemMapper simItemMapper;

    public PicServiceImpl(@Autowired PicMapper picMapper, @Autowired SimItemMapper simItemMapper) {
        this.picMapper = picMapper;
        this.simItemMapper = simItemMapper;
    }


    @Override
    public List<Pic> findPicByCid(Integer cid) {
        return picMapper.findPicByCid(cid);
    }

    @Override
    public List<Pic> findTopSimPic(Integer id) {
        List<Pic> target = picMapper.findPicById(id);
        List<Pic> list = picMapper.findAll4Train();
        Pic targetPic = null;
        if(null != target && target.size() > 0) {
            targetPic = target.get(0);
        } else {
            return null;
        }
        List<SimItemDto> sorted = new ArrayList<>();
        for(Pic p : list) {
            if(p.getId() == id) continue;
            ArrayList<Float> targetList = obj2List(targetPic);
            ArrayList<Float> itemList = obj2List(p);
            Double sim = CosHelper.similarity(targetList, itemList);
            SimItemDto dto = new SimItemDto();
            dto.setTargetId(id);
            dto.setSimId(p.getId());
            dto.setSim(sim);
            sorted.add(dto);
        }

        try {
            CompareUtils.ObjSort(sorted, "sim");
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        SimItem si = new SimItem();
        si.setPid(id);
        si.setSim1(sorted.get(0).getSimId());
        si.setSim2(sorted.get(1).getSimId());
        si.setSim3(sorted.get(2).getSimId());
        si.setSim4(sorted.get(3).getSimId());
        si.setSim5(sorted.get(4).getSimId());
        simItemMapper.insert(si);
        return null;
    }

    @Override
    public List<Pic> findAll4List(Integer uid) {
        return picMapper.findAll4List(uid);
    }

    private ArrayList<Float> obj2List(Pic p) {
        ArrayList<Float> result = new ArrayList<>();
        result.add(Float.parseFloat(p.getColorSys().toString()));
        result.add(Float.parseFloat(p.getMaterial().toString()));
        result.add(Float.parseFloat(p.getSeason().toString()));
        return result;
    }

    @Override
    public int insertOrUpdate(Pic p) {
        List<Pic> list = picMapper.findPicById(p.getId());
        if(list != null && list.size() > 0){
            return picMapper.update(p);
        }
        return picMapper.insert(p);
    }

    public int insertBatch(List<Pic> pics){
        for(Pic pic: pics){
            Pic p  = pic;
            p.setTitle(RecUtils.multiObjectDetect(pic.getPicUrl()));
            picMapper.insert(p);
        }

        return 1;
    }
}
