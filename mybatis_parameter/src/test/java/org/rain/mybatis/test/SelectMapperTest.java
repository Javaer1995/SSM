package org.rain.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.rain.mybatis.mapper.SelectMapper;
import org.rain.mybatis.pojo.User;
import org.rain.mybatis.utils.SqlSessionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/5/25 - 8:00
 */
public class SelectMapperTest {

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user = selectMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = selectMapper.getAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testGetCount(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = selectMapper.getCount();
        System.out.println(count);
        sqlSession.close();
    }

    @Test
    public void testGetUserByIdToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = selectMapper.getUserByIdToMap(1);
        System.out.println(userByIdToMap);
        sqlSession.close();
    }

    @Test
    public void testGetAllUserToMap(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        /*List<Map<String, Object>> allUserToMap = selectMapper.getAllUserToMap();
        for (Map<String, Object> map : allUserToMap) {
            System.out.println(map);
        }*/

        Map<String, Object> allUserToMap = selectMapper.getAllUserToMap();
        System.out.println(allUserToMap);
        sqlSession.close();
    }
}
