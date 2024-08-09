package org.rain.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author liaojy
 * @date 2023/8/12 - 17:56
 */

// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
public class LoggerAspect {

    @Pointcut("execution(* org.rain.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCutOne(){}

    /*
    * @Before注解：用于将方法标识为前置通知（方法）
    * @Before注解的value属性值为切入点表达式，其作用是将该前置通知（方法）安插到对应目标方法的连接点上
    * */

    // @Before("execution(public int org.rain.spring.aop.annotation.CalculatorImpl.add(int , int))")

    /**
     * 第一个*表示任意访问修饰符和返回值类型，
     * 第二个*表示该类的任意方法名称，
     * (..)表示方法的任意参数列表
     * 在类的位置也可以使用*，表示当前包下所有的类，
     * 在包的位置也可以使用*，表示当前包下所有的子包，
     */
    //@Before("execution(* org.rain.spring.aop.annotation.CalculatorImpl.*(..))")
    // @Before注解的value属性值，可以设置为使用了@Pointcut注解标识的方法名，从而复用该@Pointcut注解定义的切入点表达式
    @Before("pointCutOne()")
    // joinPoint参数：可以获取（通过切入点表达式定位出的）连接点的相关信息
    public void beforeMethod(JoinPoint joinPoint){
        // 获取连接点所对应目标方法的名称
        String methodName = joinPoint.getSignature().getName();
        // 获取连接点所对应目标方法的参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect-->前置通知，方法名："+methodName+"，参数："+ Arrays.toString(args));
    }

    // @After注解：用于将方法标识为后置通知（方法）
    @After("pointCutOne()")
    public void afterMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect-->后置通知，方法名："+methodName+"，参数："+ Arrays.toString(args));
    }


    /**
     * @AfterReturning注解：用于将方法标识为返回通知（方法）
     *  returning属性：指定（返回）通知方法中的某个参数（名），用于接收目标对象方法的返回值
     */
    @AfterReturning(value = "pointCutOne()",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect-->返回通知，方法名："+methodName+"，结果："+ result);
    }

    /**
     * @AfterThrowing注解：用于将方法标识为异常通知（方法）
     *  throwing属性：指定（异常）通知方法中的某个参数（名），用于接收目标对象方法出现的异常
     */
    @AfterThrowing(value = "pointCutOne()",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Exception ex){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect-->异常通知，方法名："+methodName+"，异常："+ ex);
    }

    /**
     * @Around注解：用于将方法标识为环绕通知（方法）
     *  环绕通知（方法）使用的参数是ProceedingJoinPoint类型
     *  环绕通知（方法）的返回值，必须和目标对象方法的返回值一致
     */
    @Around("pointCutOne()")
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
