package org.rain.spring.dao.impl;

import org.rain.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author liaojy
 * @date 2023/8/5 - 18:33
 */
@Repository
public class UserDaoImpl implements UserDao {
    public void saveUser() {
        System.out.println("保存成功");
    }
}
