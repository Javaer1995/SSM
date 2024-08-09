package org.rain.spring.aop.test;

import org.junit.Test;
import org.rain.spring.aop.xml.Calculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liaojy
 * @date 2023/8/18 - 19:07
 */
public class AOPTest {

    @Test
    public void testAOPByXML(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-aopByxml.xml");
        // 注意：这里不能直接获取目标对象来使用；因为使用了AOP之后，IOC容器中就只有对应目标对象的代理对象；
        // 如果强行获取目标对象，则报错：NoSuchBeanDefinitionException
        //Calculator calculator = ioc.getBean(CalculatorImpl.class);

        // 虽然不知道代理对象的类名，但可以通过代理对象和目标对象共同实现的接口类型来从ioc容器中获取代理对象
        Calculator calculator = ioc.getBean(Calculator.class);

        // 只能通过代理对象来访问目标对象中的方法
        calculator.div(1,1);

    }
}
