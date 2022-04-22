package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.DetailMapper;
import com.tencent.wxcloudrun.dao.ItemMapper;
import com.tencent.wxcloudrun.dao.ReviewMapper;
import com.tencent.wxcloudrun.model.Detail;
import com.tencent.wxcloudrun.model.Review;
import com.tencent.wxcloudrun.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    public static final String sb = "_";

    final ReviewMapper reviewMapper;
    final ItemMapper itemMapper;
    final DetailMapper detailMapper;

    public ReviewServiceImpl(@Autowired ReviewMapper reviewMapper,
                             @Autowired ItemMapper itemMapper,
                             @Autowired DetailMapper detailMapper) {
        this.reviewMapper = reviewMapper;
        this.itemMapper = itemMapper;
        this.detailMapper = detailMapper;
    }

    public List<Review> findReviewByBookId(Integer bookId, Integer userId, Integer familiar){
        if(familiar == null) familiar = 0;
        int replaceIndex = 0;
        Review review = new com.tencent.wxcloudrun.model.Review();
        review.setBookId(bookId);
        review.setUserId(userId);
        List<Review> reviews = reviewMapper.findReviewByBookId(review);
        if(familiar == 2){//熟悉 2/替换
            replaceIndex = 3;
        } else if(familiar == 1){ //模糊 4替换1
            replaceIndex = 5;
        } else { //不清楚，就不替换了
            return reviews;
        }
        for (Review reviewBean:
                reviews) {
            reviewBean.setContent(extractContent(reviewBean.getContent(), replaceIndex));
        }
        return reviews;
    }
    //5min 30 12 1天 2天 4天 7 天 15天
    @Override
    public int addReviewItems(Review review) {

        long time = System.currentTimeMillis();
        //
        Long min5 = time + 5 * 60 * 1000;
        review.setReviewTime(min5);
        reviewMapper.insert(review);
        Long min30 = time + 30 * 60 * 1000;
        review.setReviewTime(min30);
        reviewMapper.insert(review);
        Long min12H = time + 12 * 60 * 60 * 1000;
        review.setReviewTime(min12H);
        reviewMapper.insert(review);
        Long day1 = time + 24 * 60 * 60 * 1000;
        review.setReviewTime(day1);
        reviewMapper.insert(review);
        Long day2 = time + 48 * 60 * 60 * 1000;
        review.setReviewTime(day2);
        reviewMapper.insert(review);
        Long day4 = time + 96 * 60 * 60 * 1000;
        review.setReviewTime(day4);
        reviewMapper.insert(review);
        Long day7 = time + 168 * 60 * 60 * 1000;
        review.setReviewTime(day7);
        reviewMapper.insert(review);
        Long day15 = time + 360 * 60 * 60 * 1000;
        review.setReviewTime(day15);
        reviewMapper.insert(review);
        return 1;
    }

    @Override
    public List<Review> findReviewByTime(Integer familiar,Integer start) {
        if(familiar == null) familiar = 0;
        int replaceIndex = 0;
        List<Review> reviews = reviewMapper.findReviewByTime(start);
        if(familiar == 2){//熟悉 2/替换
            replaceIndex = 3;
        } else if(familiar == 1){ //模糊 4替换1
            replaceIndex = 5;
        } else { //不清楚，就不替换了
            return reviews;
        }
        for (Review reviewBean:
                reviews) {
            reviewBean.setContent(extractContent(reviewBean.getContent(), replaceIndex));
        }
        return reviews;
    }
    //通过ItemId 找到书籍和内容
    public int findItemDetailAndCopy(Integer itemId,Integer UserId){
        Integer bookId = itemMapper.findBookIdByItem(itemId);
        List<Detail> details = detailMapper.findDetailByItemId(itemId);
        for(Detail d: details) {
            Review r = new Review();
            r.setBookId(bookId);
            r.setUserId(UserId);
            r.setContent(d.getContent());
            this.addReviewItems(r);
        }
        return 1;
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
                i = i + replaceIndex;
            }
        }
        System.out.println("final---" + str);
        return str;
    }

}
