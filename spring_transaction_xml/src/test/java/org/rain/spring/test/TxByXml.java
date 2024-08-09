package org.rain.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rain.spring.controller.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liaojy
 * @date 2023/9/4 - 0:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-tx-xml.xml")
public class TxByXml {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }

}
