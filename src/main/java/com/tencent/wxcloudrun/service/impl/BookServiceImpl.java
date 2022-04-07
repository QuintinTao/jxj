package com.tencent.wxcloudrun.service.impl;
import com.tencent.wxcloudrun.dao.BookMapper;
import com.tencent.wxcloudrun.model.Book;
import com.tencent.wxcloudrun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    final BookMapper bookMapper;


    public BookServiceImpl(@Autowired BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<Book> getAllBooks(){
        return bookMapper.getAllBooks();
    }

}
