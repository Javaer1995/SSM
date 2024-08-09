package org.rain.dao;

import org.rain.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liaojy
 * @date 2023/10/19 - 21:36
 */
@Repository
public class EmployeeDao {

    // 通过map集合模拟数据库
    private static Map<Integer, Employee> employees = null;

    // 静态代码块在类加载时执行，并且只执行一次
    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1));
    }

    // 新数据的id
    private static Integer initId = 1006;

    // 新增或修改
    public void save(Employee employee) {
        // 参数没有id表示要执行新增操作
        if (employee.getId() == null) {
            // 设置新增数据的id，并自增id值为下一次新增数据做准备
            employee.setId(initId++);
        }
        // 更新模拟数据库的数据
        employees.put(employee.getId(), employee);
    }

    // 查询所有
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 根据id查询
    public Employee get(Integer id){
        return employees.get(id);
    }

    // 根据id删除
    public void delete(Integer id){
        employees.remove(id);
    }

}
