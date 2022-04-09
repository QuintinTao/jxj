package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.BookMapper;
import com.tencent.wxcloudrun.dao.DetailMapper;
import com.tencent.wxcloudrun.dao.ItemMapper;
import com.tencent.wxcloudrun.model.Detail;
import com.tencent.wxcloudrun.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class DetailServiceImpl implements DetailService {

    public static final String sb = "_";

   DetailMapper detailMapper;

    public DetailServiceImpl(@Autowired DetailMapper detailMapper) {
        this.detailMapper = detailMapper;
    }

    public List<Detail> findDetailByItemId(Integer itemId){
        return detailMapper.findDetailByItemId(itemId);
    }

    @Override
    public List<Detail> findReviewDetailByItemId(Integer itemId, int familiar) {
        int replaceIndex = 0; // 不进行替换
        List<Detail> details = detailMapper.findDetailByItemId(itemId);
        if(familiar == 2){//熟悉 2/替换
            replaceIndex = 3;
        } else if(familiar == 1){ //模糊 4替换1
            replaceIndex = 5;
        } else { //不清楚，就不替换了
            return details;
        }
        for (Detail detail:
             details) {
            detail.setContent(extractContent(detail.getContent(), replaceIndex));
        }
        return details;
    }

    private String extractContent(String str, int replaceIndex){
        if(str != null) {
           int i = replaceIndex;
           while (i < str.length()){
               String target = str.substring(i, i + 1);
               if(target.equals("，")|| target.equals("。")){
                   if(i + 2 < str.length()){
                       str = str.replace(str.substring(i + 1, i + 2), sb);
                   } else {
                       break;
                   }

               } else {
                   str = str.replace(target, sb);
               }
               System.out.println(str);
               i = i + replaceIndex;
           }
        }
        System.out.println("final---" + str);
        return str;
    }

//    public static void main(String[] args) {
//        DetailServiceImpl impl = new DetailServiceImpl();
//        impl.extractContent("避之有时，恬淡虚无，真气从之，精神内守，病安从来。", 5);
//    }
}
