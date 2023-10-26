package com.praga.springrestdemo.restcruddemo.dao;

import com.praga.springrestdemo.restcruddemo.entity.Employees;

import java.util.List;

public interface EmployeeDAO {

    public List<Employees> getAllEmployees();

    public Employees getEmployee(int id);

    public Employees addEmployee(Employees employee);

    public void deleteById(int id);
}
