package org.rain.spring.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author liaojy
 * @date 2023/8/15 - 7:49
 */
@Aspect
@Component
// @Order注解：用于设置切面的优先级，value属性值越小，优先级越高，默认值为Integer的最大值
@Order()
public class ValidateAspect {

    @Before("org.rain.spring.aop.annotation.LoggerAspect.pointCutOne()")
    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }

}
