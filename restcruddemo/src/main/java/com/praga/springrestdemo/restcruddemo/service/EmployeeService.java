package com.praga.springrestdemo.restcruddemo.service;

import com.praga.springrestdemo.restcruddemo.dao.EmployeeDAO;
import com.praga.springrestdemo.restcruddemo.dao.EmployeeDAOImpl;
import com.praga.springrestdemo.restcruddemo.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO){
        System.out.println("created Emp Service");
        this.employeeDAO = employeeDAO;
    }


    public List<Employees> getStudents(){
            return employeeDAO.getAllEmployees();
    }

    public Employees getStudent(int empID) {

        return employeeDAO.getEmployee(empID);
    }

    @Transactional
    public Employees addNewStudent(Employees employees){
        return employeeDAO.addEmployee(employees);
    }

    @Transactional
    public void delete(int id){
        employeeDAO.deleteById(id);
    }
}
