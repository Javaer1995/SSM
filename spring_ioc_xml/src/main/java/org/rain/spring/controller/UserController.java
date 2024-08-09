package org.rain.spring.controller;

import org.rain.spring.service.UserService;

/**
 * @author liaojy
 * @date 2023/8/5 - 11:32
 */
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void saveUser(){
        userService.saveUser();
    }
}
