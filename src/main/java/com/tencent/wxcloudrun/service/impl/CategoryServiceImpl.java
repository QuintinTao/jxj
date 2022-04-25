package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.CategoryMapper;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    final CategoryMapper categoryMapper;


    public CategoryServiceImpl(@Autowired CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public List<Category> getAllCategory(){
        return categoryMapper.getAllCategory();
    }

}
