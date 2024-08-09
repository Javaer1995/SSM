package org.rain.spring.controller;

import org.rain.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author liaojy
 * @date 2023/9/3 - 17:54
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId,userId);
    }

}
