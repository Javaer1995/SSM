package org.rain.spring.service.impl;

import org.rain.spring.service.BookService;
import org.rain.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liaojy
 * @date 2023/8/29 - 8:10
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    //一次购买多本图书
    @Transactional
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId : bookIds) {
            bookService.buyBook(bookId,userId);
        }
    }

}
