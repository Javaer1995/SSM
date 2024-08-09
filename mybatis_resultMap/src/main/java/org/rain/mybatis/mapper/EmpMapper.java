package org.rain.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.rain.mybatis.pojo.Dept;
import org.rain.mybatis.pojo.Emp;

import java.util.List;

/**
 * @author liaojy
 * @date 2023/6/7 - 0:22
 */
public interface EmpMapper {

    Emp getEmpByEmpId(@Param("empId") Integer empId);

    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);

}
