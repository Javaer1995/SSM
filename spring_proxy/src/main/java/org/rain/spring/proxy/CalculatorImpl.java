package org.rain.spring.proxy;

/**
 * @author liaojy
 * @date 2023/8/6 - 23:55
 */
public class CalculatorImpl implements Calculator {
    public int add(int i, int j) {

        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;

    }

    public int sub(int i, int j) {

        System.out.println("[日志] sub 方法开始了，参数是：" + i + "," + j);
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] sub 方法结束了，结果是：" + result);
        return result;

    }

    public int mul(int i, int j) {

        System.out.println("[日志] mul 方法开始了，参数是：" + i + "," + j);
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] mul 方法结束了，结果是：" + result);
        return result;

    }

    public int div(int i, int j) {

        System.out.println("[日志] div 方法开始了，参数是：" + i + "," + j);
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        System.out.println("[日志] div 方法结束了，结果是：" + result);
        return result;

    }
}
