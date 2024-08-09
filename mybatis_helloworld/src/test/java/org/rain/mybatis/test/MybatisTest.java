package org.rain.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.rain.mybatis.mapper.UserMapper;
import org.rain.mybatis.pojo.User;
import org.rain.mybatis.utils.SqlSessionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author liaojy
 * @date 2023/5/17 - 23:45
 */
public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        //读取MyBatis核心配置文件的输入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，用于生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.insertUser();
        //提交事务
        //sqlSession.commit();
        System.out.println("结果："+result);
        //关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser();
        sqlSession.close();
    }
    
    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = userMapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
