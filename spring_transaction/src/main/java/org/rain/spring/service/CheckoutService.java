package org.rain.spring.service;

/**
 * @author liaojy
 * @date 2023/8/29 - 8:07
 */
public interface CheckoutService {

    void checkout(Integer[] bookIds, Integer userId);

}
