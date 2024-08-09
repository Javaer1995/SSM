package org.rain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author liaojy
 * @date 2023/9/21 - 8:47
 */
@Controller
@RequestMapping("/test")
public class TestRequestMappingController {

    @RequestMapping(
            value = {"/hello","/hi"},
            method = {RequestMethod.GET,RequestMethod.POST},
            params = {"username","!password","age=18","gender!=女"},
            headers = {"referer"}
            )
    public String hello(){
        return "success";
    }

    @RequestMapping("/a*a")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/rest/{restfulId}/{restfulUsername}")
    public String testRestful(@PathVariable("restfulId") Integer id,@PathVariable("restfulUsername") String username){
        System.out.println("id："+id);
        System.out.println("username："+username);
        return "success";
    }

}
