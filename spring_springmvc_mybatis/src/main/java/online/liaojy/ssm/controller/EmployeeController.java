package online.liaojy.ssm.controller;

import com.github.pagehelper.PageInfo;
import online.liaojy.ssm.pojo.Employee;
import online.liaojy.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author liaojy
 * @date 2023/12/3 - 18:32
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        // 查询所有员工信息
        List<Employee> employees = employeeService.getAllEmployee();
        //将员工信息共享到请求域
        model.addAttribute("employees",employees);
        //跳转到员工列表页面employee_list.html
        return "employee_list";
    }

    @GetMapping(value = {"/employee/page/{pageNum}","/employee/page/{pageNum}/{pageSize}"})
    public String getAllEmployeeWithPage(Model model,
                                         @PathVariable("pageNum") Integer pageNum,
                                         @PathVariable(value = "pageSize",required = false) Integer pageSize){
        // 判断请求中是否有设置每页的数据条数，没有的话就给一个默认值
        if (pageSize == null){
            pageSize = 4;
        }
        // 根据当前页的页码，分页查询所有员工信息
        PageInfo<Employee> employeePageInfo = employeeService.getAllEmployeeWithPage(pageNum,pageSize);
        //将分页数据共享到请求域
        model.addAttribute("employeePageInfo",employeePageInfo);
        //跳转到员工列表分页的页面employee_page.html
        return "employee_page";
    }

}
