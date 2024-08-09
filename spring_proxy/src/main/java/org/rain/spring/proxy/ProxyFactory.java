package org.rain.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author liaojy
 * @date 2023/8/7 - 23:07
 */
//这个类不是一个代理类而是一个工具（工厂）类，用于动态生成目标对象的代理对象
public class ProxyFactory {

    //因为被代理的目标对象是任意的，所以目标对象变量的类型设为Object
    private Object target;

    //通过工厂类的有参构造方法，对目标对象变量进行赋值
    public ProxyFactory(Object target) {
        this.target = target;
    }

    //生成任意目标对象所对应的代理对象；因为不确定动态生成的代理对象的类型，所以返回值设为Object
    public Object getPoxy(){

        //通过目标对象获取应用类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();

        //获取目标对象实现的所有接口的class对象所组成的数组
        Class<?>[] interfaces = target.getClass().getInterfaces();

        //通过InvocationHandler的匿名内部类，来设置代理类中如何重写接口中的抽象方法
        InvocationHandler invocationHandler = new InvocationHandler() {

            //通过invoke方法来统一管理代理类中的方法该如何执行，该方法有三个参数
            /**
             * @param proxy：表示代理对象
             * @param method：表示要执行的方法
             * @param args：表示要执行的方法的参数列表
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    //在调用目标对象执行功能之前，加入额外的操作（这里是附加日志功能）
                    System.out.println("[日志] "+method.getName()+" 方法开始了，参数是：" + Arrays.toString(args));

                    //固定写法：调用目标对象实现的核心逻辑（最重要的步骤）
                    result = method.invoke(target, args);

                    //在调用目标对象执行功能之后，加入额外的操作（这里是附加日志功能）
                    System.out.println("[日志] "+method.getName()+" 方法结束了，结果是：" + result);
                } catch (Exception e) {
                    //在调用目标对象执行功能发生异常时，加入额外的操作（这里是附加日志功能）
                    System.out.println("[日志] "+method.getName()+"，异常："+e.getMessage());
                }  finally {
                    //在调用目标对象执行功能完毕时，加入额外的操作（这里是附加日志功能）
                    System.out.println("[日志] "+method.getName()+"，方法执行完毕");
                }

                //固定写法：保证代理对象和目标对象的返回值一致
                return result;
            }

        };

        //返回（java.lang.reflect包下的）Proxy类的newProxyInstance方法所生产的代理对象
        /**
         * newProxyInstance方法有三个参数：
         *
         * 1、ClassLoader classLoader：指定加载（动态生成的）代理类的类加载器
         *    类只有被加载后才能使用，（动态生成的）代理类需要用应用类加载器来加载
         *    类加载器有四种：
         *      跟类加载器（用于加载核心类库）
         *      扩展类加载器（用于加载扩展类库）
         *      应用类加载器（用于加载自己写的类或第三方jar包中的类）
         *      自定义类加载器
         *
         * 2、Class<?>[] interfaces：指定代理对象要实现的接口
         *    这个参数用于保证代理对象和目标对象有相同的方法列表
         *
         * 3、InvocationHandler invocationHandle：指定调用处理器
         *    该处理器设置了代理对象实现的接口的方法被调用时，该如何执行
         */
        return Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);

    }
}
