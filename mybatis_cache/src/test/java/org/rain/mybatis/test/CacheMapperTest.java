package org.rain.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.rain.mybatis.mapper.CacheMapper;
import org.rain.mybatis.pojo.Emp;
import org.rain.mybatis.utils.SqlSessionUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author liaojy
 * @date 2023/6/28 - 0:44
 */
public class CacheMapperTest {

    /*
    *  Mybatis的一级缓存（默认开启）是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存；
    * 下次查询相同的数据，就会从缓存中直接获取，不会从数据库重新访问
    * */
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();

        CacheMapper cacheMapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper1.getEmpById(1);
        System.out.println(emp1);

        CacheMapper cacheMapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp emp2 = cacheMapper2.getEmpById(1);
        System.out.println(emp2);
    }

    @Test
    public void testGetEmpByIdOne(){
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper1.getEmpById(1);
        System.out.println(emp1);

        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = cacheMapper2.getEmpById(1);
        System.out.println(emp2);
    }

    @Test
    public void testGetEmpByIdTwo(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);

        Emp emp1 = cacheMapper.getEmpById(1);
        System.out.println(emp1);

        Emp emp2 = cacheMapper.getEmpById(2);
        System.out.println(emp2);
    }

    @Test
    public void testGetEmpByIdThree(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);

        Emp emp1 = cacheMapper.getEmpById(1);
        System.out.println(emp1);

        Emp emp = new Emp(null, "小红", 25, "男");
        cacheMapper.insertEmp(emp);

        Emp emp2 = cacheMapper.getEmpById(1);
        System.out.println(emp2);
    }

    @Test
    public void testGetEmpByIdFour(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);

        Emp emp1 = cacheMapper.getEmpById(1);
        System.out.println(emp1);

        sqlSession.clearCache();

        Emp emp2 = cacheMapper.getEmpById(1);
        System.out.println(emp2);
    }

    @Test
    public void testSecondCache() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 二级缓存是SqlSessionFactory级别的
        // 通过同一个SqlSessionFactory创建的SqlSession查询结果才会被缓存
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper1.getEmpById(1);
        System.out.println(emp1);

        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = cacheMapper2.getEmpById(1);
        System.out.println(emp2);
    }

    @Test
    public void testSecondCacheOne() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession1 = sqlSessionFactory1.openSession(true);
        CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper1.getEmpById(1);
        System.out.println(emp1);

        sqlSession1.close();

        InputStream is2 = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory2 = sqlSessionFactoryBuilder.build(is2);
        SqlSession sqlSession2 = sqlSessionFactory2.openSession(true);
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = cacheMapper2.getEmpById(1);
        System.out.println(emp2);
    }

    @Test
    public void testSecondCacheTwo() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper1.getEmpById(1);
        System.out.println(emp1);

        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = cacheMapper2.getEmpById(2);
        System.out.println(emp2);
    }

    @Test
    public void testSecondCacheThree() throws IOException {

        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = cacheMapper1.getEmpById(1);
        System.out.println(emp1);

        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp = new Emp(null, "小红", 25, "男");
        cacheMapper2.insertEmp(emp);
        Emp emp2 = cacheMapper2.getEmpById(1);
        System.out.println(emp2);
    }

}
