package org.rain.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.rain.mybatis.pojo.Dept;

/**
 * @author liaojy
 * @date 2023/6/13 - 23:16
 */
public interface DeptMapper {

    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);

}
