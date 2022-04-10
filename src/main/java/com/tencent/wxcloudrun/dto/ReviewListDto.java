package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Item;
import com.tencent.wxcloudrun.model.Review;
import lombok.Data;

import java.util.List;

@Data
public class ReviewListDto {


    private List<Review> reviews;

    private int count;
}
