package org.rain.spring.controller;

import org.rain.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author liaojy
 * @date 2023/8/5 - 18:38
 */
@Controller("myUserController")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    public void saveUser(){
        userService.saveUser();
    }

}
