package org.rain.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * @author liaojy
 * @date 2023/8/12 - 17:45
 */

// @Component注解保证这个目标类能够放入IOC容器
@Component
public class CalculatorImpl implements Calculator {
    public int add(int i, int j) {

        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;

    }

    public int sub(int i, int j) {

        int result = i - j;
        System.out.println("方法内部 result = " + result);
        return result;

    }

    public int mul(int i, int j) {

        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;

    }

    public int div(int i, int j) {

        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;

    }
}
