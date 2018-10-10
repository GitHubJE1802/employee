package com.ch.test;

import com.ch.entity.Employee;
import com.ch.dao.EmployeeDao;
import com.ch.service.EmployeeService;
import com.ch.utils.DataSourceUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.List;

public class TestEmployee {
    //创建service层的测试对象
    EmployeeService employeeService = new EmployeeService();

    @Test
    public void testGetDataSource(){
        DataSource dataSource = DataSourceUtils.getDataSource();
        System.out.println(dataSource);

    }
    @Test
    public void testFindAllEmployee(){
        List<Employee> employees = new EmployeeDao().findAllEmployee();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    @Test
    public void testToJson(){
        List<Employee> allEmployee = employeeService.findAllEmployee();
        String json = employeeService.toJson(allEmployee);
        System.out.println(json);
    }
}
