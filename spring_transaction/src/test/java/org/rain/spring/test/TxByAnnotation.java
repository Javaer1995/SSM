package org.rain.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rain.spring.controller.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liaojy
 * @date 2023/8/27 - 1:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-tx-annotation.xml")
public class TxByAnnotation {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(2,1);
    }

    @Test
    public void testCheckout(){
        Integer[] bookIds = {1,2};
        bookController.checkout(bookIds,1);
    }

}
