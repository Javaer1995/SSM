package org.rain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author liaojy
 * @date 2023/10/19 - 12:45
 */
@Controller
public class TestRestController {

    //@RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getAllUser(){
        System.out.println("查询所有的用户信息-->/user-->GET");
        return "success";
    }

    //@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("根据id查询用户信息-->/user/"+id+"-->GET");
        return "success";
    }

    //@RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String insertUser(){
        System.out.println("新增用户信息-->/user-->POST");
        return "success";
    }

    //@RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updateUser(){
        System.out.println("修改用户信息-->/user-->PUT");
        return "success";
    }

    //@RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("根据id删除用户信息-->/user/"+id+"-->DELETE");
        return "success";
    }

}
