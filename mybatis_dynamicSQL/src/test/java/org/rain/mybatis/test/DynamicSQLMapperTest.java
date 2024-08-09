package org.rain.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.rain.mybatis.mapper.DynamicSQLMapper;
import org.rain.mybatis.pojo.Emp;
import org.rain.mybatis.utils.SqlSessionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author liaojy
 * @date 2023/6/20 - 0:30
 */
public class DynamicSQLMapperTest {

    @Test
    public void testCetEmpsByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp();
        emp.setEmpName("张三");
        emp.setAge(20);
        emp.setGender("男");
        List<Emp> emps = dynamicSQLMapper.getEmpsByCondition(emp);
        System.out.println(emps);
        sqlSession.close();
    }

    @Test
    public void testInsertMoreEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"小明1",20,"男");
        Emp emp2 = new Emp(null,"小明2",20,"男");
        Emp emp3 = new Emp(null,"小明3",20,"男");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        dynamicSQLMapper.insertMoreEmp(emps);
        sqlSession.close();
    }

    @Test
    public void testDeleteMoreEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = {6, 7};
        dynamicSQLMapper.deleteMoreEmp(empIds);
        sqlSession.close();
    }
}
