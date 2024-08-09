package online.liaojy.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author liaojy
 * @date 2023/11/13 - 20:42
 */
// @ControllerAdvice 注解：用于将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    // @ExceptionHandler 注解：用来设置（该方法）要处理的异常
    @ExceptionHandler(ArithmeticException.class)
    public String testHandleException(Throwable ex,Model model){

        // 设置共享到请求域中的异常信息的属性名
        model.addAttribute("exceptionMessage",ex);

        // 返回发生异常时的逻辑视图
        return "errorPage";
    }

}
