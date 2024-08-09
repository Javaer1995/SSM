package org.rain.mybatis.test;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.rain.mybatis.mapper.EmpMapper;
import org.rain.mybatis.pojo.Emp;
import org.rain.mybatis.pojo.EmpExample;
import org.rain.mybatis.utils.SqlSessionUtils;

import java.util.List;

/**
 * @author liaojy
 * @date 2023/7/8 - 16:34
 */
public class MbgTest {

    @Test
    public void testMbg(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        //根据主键查询一条数据
        /*Emp emp = empMapper.selectByPrimaryKey(1);
        System.out.println(emp);*/

        //查询所有数据
        /*List<Emp> emps = empMapper.selectByExample(null);
        for (Emp emp : emps) {
            System.out.println(emp);
        }*/

        //多条件查询，QBC（query by condition）风格
        /*EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("小红").andEmpIdBetween(8,10);
        empExample.or().andAgeEqualTo(20);
        List<Emp> emps = empMapper.selectByExample(empExample);
        for (Emp emp : emps) {
            System.out.println(emp);
        }*/

        /*Emp emp = new Emp();
        emp.setEmpId(4);
        emp.setEmpName("小军");
        emp.setAge(null);
        emp.setGender("女");
        empMapper.updateByPrimaryKey(emp);*/

        Emp emp = new Emp();
        emp.setEmpId(3);
        emp.setEmpName("小军");
        emp.setAge(null);
        emp.setGender("女");
        empMapper.updateByPrimaryKeySelective(emp);
    }

}
