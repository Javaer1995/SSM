package org.rain.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;

        try {
            //读取MyBatis核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，用于生产SqlSession对象
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //创建自动提交事务的SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
