package online.liaojy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import online.liaojy.ssm.mapper.EmployeeMapper;
import online.liaojy.ssm.pojo.Employee;
import online.liaojy.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liaojy
 * @date 2023/12/4 - 20:34
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    public PageInfo<Employee> getAllEmployeeWithPage(Integer pageNum,Integer pageSize) {

        // 在查询之前，开启分页功能，并设置当前页的页码和每页的数据条数
        PageHelper.startPage(pageNum,pageSize);

        // 查询所有的员工信息（）
        // 分页插件会在查询前先进行拦截，添加相关的sql分页代码后（因此在mapper映射文件编写的sql不能使用分号结束），再放行
        List<Employee> employees = employeeMapper.getAllEmployee();

        // 根据分页数据（employees）和分页导航的页码数（navigatePages），创建分页数据对象
        PageInfo<Employee> employeePageInfo = new PageInfo<Employee>(employees, 5);

        return employeePageInfo;
    }

}
