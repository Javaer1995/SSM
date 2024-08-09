package org.rain.spring.controller;

import org.rain.spring.service.BookService;
import org.rain.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author liaojy
 * @date 2023/8/27 - 1:07
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutService;

    public void checkout(Integer[] bookIds, Integer userId){
        checkoutService.checkout(bookIds, userId);
    }

    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId,userId);
    }

}
