package com.wangqiang.springboot.dao;

import com.wangqiang.springboot.eneities.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDao {
    private static Map<Integer, Employee> employees= new HashMap<>();

    static {
        employees.put(1001,new Employee(1001,"E-AA","aaa@163.com",0));
        employees.put(1002,new Employee(1002,"E-BB","bbb@163.com",1));
        employees.put(1003,new Employee(1003,"E-CC","ccc@163.com",0));
        employees.put(1004,new Employee(1004,"E-DD","ddd@163.com",1));
        employees.put(1005,new Employee(1005,"E-EE","eee@163.com",0));
    }

    private static int initInt = 1006;

    public void add(Employee employee){
        if (0000 == employee.getId()){
            employee.setId(initInt++);
        }
        employees.put(initInt,employee);
    }

    //查询所有员工
    public Collection<Employee> getAll(){
        return employees.values();
    }


    //查询指定员工
    public Employee get(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
