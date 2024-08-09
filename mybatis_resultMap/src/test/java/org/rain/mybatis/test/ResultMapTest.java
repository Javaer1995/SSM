package org.rain.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.rain.mybatis.mapper.DeptMapper;
import org.rain.mybatis.mapper.EmpMapper;
import org.rain.mybatis.pojo.Dept;
import org.rain.mybatis.pojo.Emp;
import org.rain.mybatis.utils.SqlSessionUtils;

/**
 * @author liaojy
 * @date 2023/6/7 - 8:05
 */
public class ResultMapTest {

    @Test
    public void testGetEmpByEmpId(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpByEmpId(1);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptByEmpId(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByEmpId(1);
        System.out.println(emp);
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpByDeptId(1);
        System.out.println(dept);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = empMapper.getEmpAndDeptByStepOne(1);
        System.out.println(emp.getEmpName());
        sqlSession.close();
    }

    @Test
    public void testGetDeptAndEmpByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = deptMapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept);
        sqlSession.close();
    }
}
