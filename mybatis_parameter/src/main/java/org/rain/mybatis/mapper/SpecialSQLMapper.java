package org.rain.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.rain.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/6/4 - 17:54
 */
public interface SpecialSQLMapper {

    List<User> getUserByLike(@Param("mohu") String mohu);

    void deleteMoreUser(@Param("ids") String ids);

    List<Map<String,Object>> getAllData(@Param("tableName") String tableName);

    void insertUser(User user);

}
