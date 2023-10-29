package com.praga.springrestdemo.restcruddemo.controller;

import com.praga.springrestdemo.restcruddemo.entity.Employees;
import com.praga.springrestdemo.restcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //got listing employees

    @GetMapping("/list")
    public String getAllEmployees(Model model){
        List<Employees> list = employeeService.getStudents();
        model.addAttribute("employees", list);
        return "listEmp";
    }

}
