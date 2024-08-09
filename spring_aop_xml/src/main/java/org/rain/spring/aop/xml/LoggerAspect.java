package org.rain.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author liaojy
 * @date 2023/8/18 - 8:15
 */
// @Component注解：保证这个目标类能够放入IOC容器
@Component
public class LoggerAspect {

    // joinPoint参数：可以获取（通过切入点表达式定位出的）连接点的相关信息
    public void beforeMethod(JoinPoint joinPoint){
        // 获取连接点所对应目标方法的名称
        String methodName = joinPoint.getSignature().getName();
        // 获取连接点所对应目标方法的参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect-->前置通知，方法名："+methodName+"，参数："+ Arrays.toString(args));
    }

    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect-->后置通知，方法名："+methodName+"，参数："+ Arrays.toString(args));
    }

    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect-->返回通知，方法名："+methodName+"，结果："+ result);
    }

    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect-->异常通知，方法名："+methodName+"，异常："+ ex);
    }

    /**
     *  环绕通知（方法）使用的参数是ProceedingJoinPoint类型
     *  环绕通知（方法）的返回值，必须和目标对象方法的返回值一致
     */
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint){
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("LoggerAspect-->环绕前置通知，方法名："+methodName+"，参数："+ Arrays.toString(args));
            // 表示目标对象方法的执行
            result = proceedingJoinPoint.proceed();
            System.out.println("LoggerAspect-->环绕返回通知，方法名："+methodName+"，结果："+ result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("LoggerAspect-->环绕异常通知，方法名："+methodName+"，异常："+ throwable);
        }finally {
            System.out.println("LoggerAspect-->环绕后置通知，方法名："+methodName+"，参数："+ Arrays.toString(args));
        }
        return result;
    }

}
