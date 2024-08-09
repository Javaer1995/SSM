package org.rain.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.rain.mybatis.pojo.Emp;

import java.util.List;

/**
 * @author liaojy
 * @date 2023/6/20 - 0:16
 */
public interface DynamicSQLMapper {

    List<Emp> getEmpsByCondition(Emp emp);

    void insertMoreEmp(@Param("emps") List<Emp> emps);

    void deleteMoreEmp(@Param("empIds") Integer[] empIds);

}
