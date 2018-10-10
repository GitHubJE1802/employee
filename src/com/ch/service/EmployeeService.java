package com.ch.service;

import com.ch.entity.Employee;
import com.ch.dao.EmployeeDao;
import flexjson.JSONSerializer;
import java.util.List;

/**
 * 员工的业务层
 */
public class EmployeeService {
    //调用dao层
    private EmployeeDao employeeDao = new EmployeeDao();
    //查询所有员工列表
    public List<Employee> findAllEmployee(){

        return  employeeDao.findAllEmployee();
    }

    /**
     * 将数据转换成json对象
     * @param employees
     * @return
     */
    public String toJson(List<Employee> employees){
//        创建json转换对象
        JSONSerializer serializer = new JSONSerializer();
//        [排除class属性
        serializer.exclude("class");
        return serializer.serialize(employees);
    }

}
