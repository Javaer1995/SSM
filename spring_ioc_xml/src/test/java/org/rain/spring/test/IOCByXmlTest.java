package org.rain.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.rain.spring.controller.UserController;
import org.rain.spring.pojo.Clazz;
import org.rain.spring.pojo.Student;
import org.rain.spring.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author liaojy
 * @date 2023/7/27 - 22:43
 */
public class IOCByXmlTest {

    @Test
    public void testDISetter(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIConstructor(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("studentTwo", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIspecial(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("studentThree", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIOuterBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("studentfour", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDICascade(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("studentFive", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIInnerBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("studentSix", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("studentSeven", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIList(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Clazz clazz = applicationContext.getBean("clazzTwo", Clazz.class);
        System.out.println(clazz);
    }

    @Test
    public void testDIMap(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("studentEight", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("studentNine", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = applicationContext.getBean("studentTen", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIOuterFile() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-datasource");
        DruidDataSource datasource = applicationContext.getBean("datasource", DruidDataSource.class);
        System.out.println(datasource.getConnection());
    }

    @Test
    public void testScope() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student student1 = applicationContext.getBean(Student.class);
        Student student2 = applicationContext.getBean(Student.class);
        System.out.println(student1 == student2);
    }

    @Test
    public void testLifecycle(){
        //ConfigurableApplicationContext是ApplicationContext子接口，扩展了刷新和关闭容器的方法
        ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
        ioc.close();
    }

    @Test
    public void testAutoWireByXML(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }

}
