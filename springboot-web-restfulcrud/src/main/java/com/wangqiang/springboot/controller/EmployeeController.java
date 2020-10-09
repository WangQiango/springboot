package com.wangqiang.springboot.controller;

import com.wangqiang.springboot.dao.EmployeeDao;
import com.wangqiang.springboot.eneities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中进行共享
        model.addAttribute("emps",employees);
        return "/emp/list";
    }
}
