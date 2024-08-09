package org.rain.spring.aop.xml;

import org.springframework.stereotype.Component;

/**
 * @author liaojy
 * @date 2023/8/20 - 23:59
 */
// @Component注解：保证这个目标类能够放入IOC容器
@Component
public class ValidateAspect {

    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }

}
