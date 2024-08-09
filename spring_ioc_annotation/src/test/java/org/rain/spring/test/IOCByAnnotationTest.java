package org.rain.spring.test;

import org.junit.Test;
import org.rain.spring.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liaojy
 * @date 2023/8/5 - 19:18
 */
public class IOCByAnnotationTest {

    @Test
    public void testAutowireByAnnotation(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();

    }
}
