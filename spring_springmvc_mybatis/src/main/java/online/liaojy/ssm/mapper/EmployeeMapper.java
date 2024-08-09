package online.liaojy.ssm.mapper;

import online.liaojy.ssm.pojo.Employee;

import java.util.List;

/**
 * @author liaojy
 * @date 2023/12/4 - 7:00
 */
public interface EmployeeMapper {

    /**
     * 查询所有员工信息
     * @return
     */
    List<Employee> getAllEmployee();

}
