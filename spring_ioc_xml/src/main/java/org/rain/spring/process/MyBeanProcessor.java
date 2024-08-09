package org.rain.spring.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author liaojy
 * @date 2023/8/4 - 23:52
 */
public class MyBeanProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanProcessor-->后置处理器postProcessBeforeInitialization");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanProcessor-->后置处理器postProcessAfterInitialization");
        return bean;
    }
}
