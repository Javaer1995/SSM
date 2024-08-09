package org.rain.controller;

import org.rain.dao.EmployeeDao;
import org.rain.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author liaojy
 * @date 2023/10/20 - 12:37
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        // 获取所有员工的信息
        Collection<Employee> allEmployee = employeeDao.getAll();
        // 将所有员工的信息，共享到请求域
        model.addAttribute("allEmployee",allEmployee);
        // 跳转到列表页面
        return "employee_list";
    }

    @PostMapping("/employee")
    public String insertEmployee(Employee employee){
        // 新增员工
        employeeDao.save(employee);
        // 重定向到查询列表功能
        return "redirect:/employee";
    }

    @GetMapping("/to/update/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        // 根据id查询员工信息
        Employee employee = employeeDao.get(id);
        // 将员工信息共享到请求域
        model.addAttribute("employee",employee);
        // 跳转到更新页面
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        // 修改员工
        employeeDao.save(employee);
        // 重定向到查询列表功能
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        // 删除员工
        employeeDao.delete(id);
        // 重定向到查询列表功能
        return "redirect:/employee";
    }

}
