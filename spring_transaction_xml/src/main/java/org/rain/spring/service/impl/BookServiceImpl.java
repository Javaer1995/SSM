package org.rain.spring.service.impl;

import org.rain.spring.dao.BookDao;
import org.rain.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaojy
 * @date 2023/9/3 - 17:53
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public void buyBook(Integer bookId, Integer userId) {

        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);

        //更新图书的库存
        bookDao.updateStockOfBook(bookId);

        //更新用户的余额
        bookDao.updateBalanceOfUser(userId,price);

    }
}
