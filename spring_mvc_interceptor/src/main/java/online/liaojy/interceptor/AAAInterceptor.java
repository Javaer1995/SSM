package online.liaojy.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liaojy
 * @date 2023/11/7 - 20:57
 */
// SpringMVC 中的拦截器要实现 HandlerInterceptor 接口
@Component
public class AAAInterceptor implements HandlerInterceptor {

    // preHandle()方法在控制器方法执行之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AAAInterceptor-->preHandle()");

        // 返回true表示不拦截，即执行控制器方法
        // 返回false表示拦截，即不再执行控制器方法
        return true;
    }

    // postHandle()方法在控制器方法执行之后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("AAAInterceptor-->postHandle()");
    }

    // afterCompletion()方法在渲染完视图之后执行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AAAInterceptor-->afterCompletion()");
    }

}
