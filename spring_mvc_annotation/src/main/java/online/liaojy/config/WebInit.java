package online.liaojy.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author liaojy
 * @date 2023/11/17 - 0:04
 */
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 指定代替 Spring 配置文件的配置类（可以按功能或需要来划分多个）
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // 指定代替 SpringMVC 配置文件的配置类（可以按功能或需要来划分多个）
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class};
    }

    // 设置 SpringMVC 的前端控制器 DispatcherServlet 需要处理的请求路径（即 url-pattern ）
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // 设置过滤器
    @Override
    protected Filter[] getServletFilters() {

        // 配置编码过滤器
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        // 配置处理请求方式的过滤器
        // 注意该过滤器所在的包路径为 org.springframework.web.filter.HiddenHttpMethodFilter
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        // 配置要使用的过滤器
        return new Filter[]{characterEncodingFilter,hiddenHttpMethodFilter};

    }
}
