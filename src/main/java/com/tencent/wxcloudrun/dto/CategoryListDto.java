package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CategoryListDto {

    private List<Category> categories;

    private int count;
}
