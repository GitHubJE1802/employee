package com.ch.dao;

import com.ch.entity.Employee;
import com.ch.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;
/**
 * 数据访问类
 */
public class EmployeeDao {

//    通过工具类得到数据源对象,传递给QueryRunner对象
    private QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

//    查询所有员工
    public List<Employee> findAllEmployee() {

        try {
            return (List<Employee>) runner.query("select * from employee",new BeanListHandler(Employee.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }
}
