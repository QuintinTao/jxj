package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BookListDto;
import com.tencent.wxcloudrun.dto.CategoryListDto;
import com.tencent.wxcloudrun.model.Book;
import com.tencent.wxcloudrun.model.Category;
import com.tencent.wxcloudrun.service.BookService;
import com.tencent.wxcloudrun.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * counter控制器
 */
@RestController

public class CategoryController {

  final CategoryService categoryService;
  final Logger logger;

  public CategoryController(@Autowired CategoryService categoryService) {
    this.categoryService = categoryService;
    this.logger = LoggerFactory.getLogger(CategoryController.class);
  }

  @GetMapping(value = "/api/getAllCategories")
  ApiResponse getAllCategories() {
    logger.info("/api/get all categories get request");
    List<Category> result = categoryService.getAllCategory();
    CategoryListDto dto = new CategoryListDto();
    dto.setCategories(result);
    dto.setCount(result.size());
    return ApiResponse.ok(dto);
  }


}