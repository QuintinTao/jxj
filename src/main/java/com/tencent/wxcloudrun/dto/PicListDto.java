package com.tencent.wxcloudrun.dto;

import com.tencent.wxcloudrun.model.Book;
import lombok.Data;

import java.util.List;
@Data
public class BookListDto {

    private List<Book> books;

    private int count;
}
