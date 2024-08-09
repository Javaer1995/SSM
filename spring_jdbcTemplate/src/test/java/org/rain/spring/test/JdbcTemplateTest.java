package org.rain.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rain.spring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/8/22 - 7:43
 */

// @RunWith注解：表示使用 SpringJUnit4ClassRunner 运行器来运行测试方法
    // 这样测试类便在Spring的测试环境中执行，此时就可以通过注入的方式直接获取IOC容器中的bean
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration注解：用来指定加载ApplicationContext的配置文件或配置类
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert(){
        String sql = "insert into t_user values(null,?,?,?,?,?)";
        jdbcTemplate.update(sql,"jdbcTemplate","123",23,"男","123@qq.com");
    }

    @Test
    public void testGetUserById(){
        String sql = "select * from t_user where id = ?";
        // 第一个参数是设置要执行的sql语句，第二个参数是设置查询结果和实体类的对应关系，后面的参数列表是设置sql语句中占位符的值
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), 10);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        String sql = "select * from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUserCount(){
        String sql = "select count(*) from t_user";
        // 第二个参数是设置查询结果对应的Java类型；如果sql中有占位符，后面可以用参数列表来设置sql语句中占位符的值
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("用户数量为："+integer);
    }

    @Test
    public void testHtest(){
        /*String sql = "select count(*) from SF_USER";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("用户数量为："+integer);*/

        String sql = "select * from SF_USER where id = 1";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        System.out.println("用户数量为："+map);
    }

}
