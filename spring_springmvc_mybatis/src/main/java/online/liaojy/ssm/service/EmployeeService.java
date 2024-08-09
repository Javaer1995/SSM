package online.liaojy.ssm.service;

import com.github.pagehelper.PageInfo;
import online.liaojy.ssm.pojo.Employee;

import java.util.List;

/**
 * @author liaojy
 * @date 2023/12/4 - 20:32
 */
public interface EmployeeService {

    /**
     * 查询所有员工信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 分页查询所有员工信息
     * @param pageNum
     * @return
     */
    PageInfo<Employee> getAllEmployeeWithPage(Integer pageNum,Integer pageSize);

}
