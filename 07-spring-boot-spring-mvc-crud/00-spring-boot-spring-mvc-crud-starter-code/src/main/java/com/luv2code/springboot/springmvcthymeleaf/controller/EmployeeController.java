package com.luv2code.springboot.springmvcthymeleaf.controller;

import com.luv2code.springboot.springmvcthymeleaf.entity.Employee;
import com.luv2code.springboot.springmvcthymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping("/list")
    public String getAllEmployees(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "employees/empList";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employees", employee);

        return "employees/emp-form";
    }

    @GetMapping("/showFormUpdate/")
    public String getEmpById(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employees", employee);
        return "employees/emp-form";
    }

    @GetMapping("/delete/")
    public String deleteById(@RequestParam("empId") int id){
       employeeService.deleteById(id);
        return"redirect:/employees/list";
    }



    @PostMapping("/save")
    public String saveForm(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return"redirect:/employees/list";
    }
}
