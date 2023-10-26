package com.praga.springrestdemo.restcruddemo.dao;

import com.praga.springrestdemo.restcruddemo.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
}
