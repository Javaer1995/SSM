package online.liaojy.controller;

import online.liaojy.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/10/27 - 20:11
 */
@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAajx(Integer id , @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        // 通过形参获取 url 中的请求参数
        System.out.println("id："+id);

        // 通过 @RequestBody 注解后的形参，获取请求体中的内容
        System.out.println("requestBody："+requestBody);

        // 通过 HttpServletResponse 对象为 Ajax 请求响应（字符串）数据
        response.getWriter().write("hello,ajax");
    }

    // 通过 @RequestBody 注解形参，将json格式的请求参数转换为Java对象(自定义实体类)
    /*@RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody User user,HttpServletResponse response) throws IOException {
        System.out.println("user："+user);
        response.getWriter().write("hello,RequestBody");
    }*/

    // 通过 @RequestBody 注解形参，将json格式的请求参数转换为Java对象(map集合)
    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println("map："+map);
        response.getWriter().write("hello,RequestBody");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public List<User> testResponseBodyjson(){
        User user1 = new User(1001, "admin1", "123456", 28, "男");
        User user2 = new User(1002, "admin2", "123456", 28, "男");
        User user3 = new User(1003, "admin3", "123456", 28, "男");
        LinkedList<User> users = new LinkedList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        return users;
    }
    /*public Map<String,Object> testResponseBodyjson(){
        User user1 = new User(1001, "admin1", "123456", 28, "男");
        User user2 = new User(1002, "admin2", "123456", 28, "男");
        User user3 = new User(1003, "admin3", "123456", 28, "男");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1001",user1);
        map.put("1002",user2);
        map.put("1003",user3);
        return map;
    }*/
    /*public User testResponseBodyjson(){
        User user = new User(1001, "admin", "123456", 28, "男");
        return user;
    }*/

}
