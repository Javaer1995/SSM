package org.rain.spring.service.impl;

import org.rain.spring.dao.UserDao;
import org.rain.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaojy
 * @date 2023/8/5 - 18:36
 */
@Service("myUserService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser() {
        userDao.saveUser();
    }

}
