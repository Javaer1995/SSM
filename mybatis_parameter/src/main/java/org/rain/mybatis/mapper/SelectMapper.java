package org.rain.mybatis.mapper;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.rain.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/5/25 - 7:57
 */
public interface SelectMapper {

    User getUserById(@Param("id") Integer id);

    List<User> getAllUser();

    Integer getCount();

    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /*List<Map<String,Object>> getAllUserToMap();*/

    @MapKey("ID")
    Map<String,Object> getAllUserToMap();

}
