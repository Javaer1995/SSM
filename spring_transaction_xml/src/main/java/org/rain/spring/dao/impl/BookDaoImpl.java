package org.rain.spring.dao.impl;

import org.rain.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author liaojy
 * @date 2023/9/3 - 17:36
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer getPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class,bookId);
        return price;
    }

    public void updateStockOfBook(Integer bookId) {
        String sql = "update t_book set stock = stock -1 where book_id = ?";
        jdbcTemplate.update(sql, bookId);
    }

    public void updateBalanceOfUser(Integer userId, Integer price) {
        String sql = "update t_user set balance = balance - ? where user_id = ?";
        jdbcTemplate.update(sql,price,userId);
    }

}
