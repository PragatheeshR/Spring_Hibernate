package com.praga.springrestdemo.restcruddemo.service;

import com.praga.springrestdemo.restcruddemo.dao.EmployeeRepository;
import com.praga.springrestdemo.restcruddemo.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        System.out.println("created Emp Service");
        this.employeeRepository = employeeRepository;
    }


    public List<Employees> getStudents(){
            return employeeRepository.findAll();
    }

    public Employees getStudent(int empID) {

        return employeeRepository.findById(empID).get();
    }


    public Employees addNewStudent(Employees employees){
        return employeeRepository.save(employees);
    }

   // not needed  @Transactional because Spring JPA provides this
    public void delete(int id){
        employeeRepository.deleteById(id);
    }
}
