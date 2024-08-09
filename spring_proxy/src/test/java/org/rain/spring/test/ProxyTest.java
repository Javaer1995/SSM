package org.rain.spring.test;

import org.junit.Test;
import org.rain.spring.proxy.Calculator;
import org.rain.spring.proxy.CalculatorImpl;
import org.rain.spring.proxy.CalculatorStaticProxy;
import org.rain.spring.proxy.ProxyFactory;

/**
 * @author liaojy
 * @date 2023/8/7 - 14:12
 */
public class ProxyTest {

    @Test
    public void testStaticProxy(){
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(new CalculatorImpl());
        int addResult = calculatorStaticProxy.add(1, 2);
        System.out.println(addResult);
    }

    @Test
    public void testDynamicProxy(){

        //根据目标对象来创建（动态）代理对象的工厂
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());

        //通过（动态）代理对象的工厂，生成目标对象所对应的（动态）代理对象
        //因为代理类是动态生成的，所以不确定代理类的类型，因此用其所实现的接口类型
        Calculator poxy = (Calculator) proxyFactory.getPoxy();

        //调用动态代理对象的方法，该方法是目标对象核心业务方法的增强方法
        int addResult = poxy.add(1, 2);
        System.out.println(addResult);

    }

}
