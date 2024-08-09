package org.rain.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.rain.mybatis.pojo.User;

import java.util.Map;

/**
 * @author liaojy
 * @date 2023/5/22 - 23:53
 */
public interface UserMapper {

    User getUserByUsername(String username);

    User checkLogin(String username,String password);

    User checkLoginByMap(Map<String,Object> map);

    void insertUser(User user);

    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
