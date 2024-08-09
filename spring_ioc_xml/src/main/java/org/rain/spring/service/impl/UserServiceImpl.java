package org.rain.spring.service.impl;

import org.rain.spring.dao.UserDao;
import org.rain.spring.service.UserService;

/**
 * @author liaojy
 * @date 2023/8/5 - 11:23
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser() {
        userDao.saveUser();
    }
}
