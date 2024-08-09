package org.rain.mybatis.mapper;

import org.rain.mybatis.pojo.User;

import java.util.List;

/**
 * @author liaojy
 * @date 2023/4/25 - 23:57
 */
public interface UserMapper {

    int insertUser();

    void updateUser();

    void deleteUser();

    User getUserById();

    List<User> getAllUser();

}
