package org.rain.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.rain.mybatis.pojo.Emp;

/**
 * @author liaojy
 * @date 2023/6/28 - 0:41
 */
public interface CacheMapper {

    Emp getEmpById(@Param("empId") Integer empId);

    void insertEmp(Emp emp);

}
