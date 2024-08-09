package org.rain.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.rain.mybatis.mapper.UserMapper;
import org.rain.mybatis.pojo.User;
import org.rain.mybatis.utils.SqlSessionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/5/23 - 7:54
 */
public class ParameterTest {

    @Test
    public void testGerUserByUsername(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername("root");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("root","123");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("username","root");
        map.put("password","123");
        User user = userMapper.checkLoginByMap(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        user.setAge(55);
        user.setGender("男");
        user.setEmail("123@qq.com");
        userMapper.insertUser(user);
        sqlSession.close();
    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLoginByParam("root","123");
        System.out.println(user);
        sqlSession.close();
    }
}
