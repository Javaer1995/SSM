package org.rain.spring.service.impl;

import org.rain.spring.dao.BookDao;
import org.rain.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author liaojy
 * @date 2023/8/27 - 1:02
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    // 表示不管是否有已经开启的事务，都要开启新事务
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void buyBook(Integer bookId, Integer userId) {

        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);

        //更新图书的库存
        bookDao.updateStockOfBook(bookId);

        //更新用户的余额
        bookDao.updateBalanceOfUser(userId,price);

    }

}
