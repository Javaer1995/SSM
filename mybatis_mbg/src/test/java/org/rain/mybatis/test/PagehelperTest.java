package org.rain.mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.rain.mybatis.mapper.EmpMapper;
import org.rain.mybatis.pojo.Emp;
import org.rain.mybatis.utils.SqlSessionUtils;

import java.util.List;

/**
 * @author liaojy
 * @date 2023/7/14 - 0:06
 */
public class PagehelperTest {

    @Test
    public void testPagehelper(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);

        //在查询之前，使用PageHelper.startPage(int pageNum, int pageSize)开启分页功能
        //pageNum：当前页的页码
        //pageSize：每页显示的条数
        PageHelper.startPage(2,3);

        List<Emp> emps = empMapper.selectByExample(null);

        //在查询获取list集合之后，使用PageInfo<T> pageInfo = new PageInfo<>(List<T> list, int navigatePages)获取分页相关数据
        //list：分页之后的数据
        //navigatePages：导航分页的页码数
        PageInfo<Emp> empPageInfo = new PageInfo<Emp>(emps,3);
        System.out.println(empPageInfo);
    }

}
