package org.rain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/10/11 - 20:13
 */
@Controller
public class ScopeController {

    @RequestMapping("/test/servletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope","Hello,ServletAPI!");
        return "success";
    }

    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * ModelAndView包含Model和View的功能
         * Model的功能：向请求域中共享数据
         * View的功能：设置逻辑视图，实现页面调整
         */
        ModelAndView mav = new ModelAndView();
        // 向请求域中共享数据
        mav.addObject("testRequestScope","Hello,ModelAndView!");
        // 设置逻辑视图，实现页面调整
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/test/model")
    public String testModel(Model model){
        System.out.println("真实类型："+model.getClass().getName());
        model.addAttribute("testRequestScope","Hello,Model!");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        System.out.println("真实类型："+modelMap.getClass().getName());
        modelMap.addAttribute("testRequestScope","Hello,ModelMap!");
        return "success";
    }

    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> map){
        System.out.println("真实类型："+map.getClass().getName());
        map.put("testRequestScope","Hello,Map!");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession httpSession){
        httpSession.setAttribute("testSessionScope","Hello,HttpSession!");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession httpSession){
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute("testApplicationScope","Hello,Application!");
        return "success";
    }

}
