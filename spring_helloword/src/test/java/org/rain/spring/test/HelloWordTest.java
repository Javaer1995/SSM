package org.rain.spring.test;

import org.junit.Test;
import org.rain.spring.component.Hello;
import org.rain.spring.component.HelloWord;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liaojy
 * @date 2023/7/25 - 19:39
 */
public class HelloWordTest {

    @Test
    public void testHelloWord(){
        //获取IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据接口类型获取IOC容器中的bean
        HelloWord helloWord = (HelloWord) applicationContext.getBean(Hello.class);
        helloWord.sayHello();
    }
}
