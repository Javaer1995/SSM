package online.liaojy.config;

import online.liaojy.interceptor.AAAInterceptor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.List;
import java.util.Properties;

/**
 * @author liaojy
 * @date 2023/11/17 - 0:02
 * 该类用于代替SpringMVC的配置文件
 */

// @Configurable 注解：将类标识为配置类
@Configurable
// @ComponentScan 注解：用于扫描指定包的组件
@ComponentScan("online.liaojy.controller")
// @EnableWebMvc 注解：开启mvc的注解驱动
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {

    // 配置默认servlet处理器
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // 配置视图控制器
    public void addViewControllers(ViewControllerRegistry registry) {
        // addViewController 设置视图控制器要处理的请求路径，setViewName 设置匹配请求路径的逻辑视图
        registry.addViewController("/").setViewName("index");
    }

    // 配置文件上传解析器
    // @Bean 注解：用于将所标识方法的返回值作为一个 bean 来进行管理，bean的id为方法名
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

    // 配置拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        AAAInterceptor aaaInterceptor = new AAAInterceptor();
        // addInterceptor 设置要使用的拦截器，
        // addPathPatterns 设置该拦截器要拦截的请求路径（ /** 表示所有路径），excludePathPatterns 设置要排除的拦截路径
        registry.addInterceptor(aaaInterceptor).addPathPatterns("/**").excludePathPatterns("/abc");
    }

    // 配置异常解析器
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

        // 创建 SimpleMappingExceptionResolver 异常解析器，来对控制器方法出现的异常进行自定义异常处理
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();

        // 设置异常和错误提示页面的映射关系
        Properties properties = new Properties();
        properties.setProperty("java.lang.ArithmeticException", "errorPage");
        simpleMappingExceptionResolver.setExceptionMappings(properties);

        // 设置共享到域对象中的异常信息的属性名
        simpleMappingExceptionResolver.setExceptionAttribute("exceptionMessage");

        // 添加要使用的异常解析器器
        resolvers.add(simpleMappingExceptionResolver);
    }

    //配置生成模板解析器
    @Bean
    public ITemplateResolver templateResolver() {

        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        // ServletContextTemplateResolver 需要一个 ServletContext 作为构造参数，可通过 WebApplicationContext 的方法获得
        ServletContextTemplateResolver templateResolver =
                new ServletContextTemplateResolver(webApplicationContext.getServletContext());

        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        return templateResolver;

    }

    //生成模板引擎并为模板引擎注入模板解析器
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    //生成视图解析器并为解析器注入模板引擎
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

}
