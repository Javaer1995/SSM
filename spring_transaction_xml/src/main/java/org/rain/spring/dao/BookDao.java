package org.rain.spring.dao;

/**
 * @author liaojy
 * @date 2023/9/3 - 17:34
 */
public interface BookDao {

    /**
     * 查询图书的价格
     * @param bookId
     * @return
     */
    Integer getPriceByBookId(Integer bookId);

    /**
     * 更新图书的库存
     * @param bookId
     */
    void updateStockOfBook(Integer bookId);

    /**
     * 更新用户的余额
     * @param userId
     * @param price
     */
    void updateBalanceOfUser(Integer userId,Integer price);

}
