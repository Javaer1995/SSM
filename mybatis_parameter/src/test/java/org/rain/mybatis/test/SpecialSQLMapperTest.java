package org.rain.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.rain.mybatis.mapper.SpecialSQLMapper;
import org.rain.mybatis.pojo.User;
import org.rain.mybatis.utils.SqlSessionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/6/4 - 18:34
 */
public class SpecialSQLMapperTest {

    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> users = specialSQLMapper.getUserByLike("a");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testDeleteMoreUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        specialSQLMapper.deleteMoreUser("7,8");
        sqlSession.close();
    }

    @Test
    public void testGetAllData(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<Map<String, Object>> t_user = specialSQLMapper.getAllData("t_user");
        for (Map<String, Object> map : t_user) {
            System.out.println(map);
        }
        sqlSession.close();
    }

    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User();
        user.setUsername("111");
        user.setPassword("111");
        user.setEmail("111@11.com");
        user.setGender("1");
        user.setAge(11);
        System.out.println(user);
        specialSQLMapper.insertUser(user);
        System.out.println(user);
        sqlSession.close();
    }
}
