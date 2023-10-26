package com.praga.springrestdemo.restcruddemo.dao;

import com.praga.springrestdemo.restcruddemo.entity.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        System.out.println("created Emp DAo");
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public List<Employees> getAllEmployees() {
        TypedQuery<Employees> fromEmployees = entityManager.createQuery("from Employees", Employees.class);
        return fromEmployees.getResultList();
    }

    @Override
    public Employees getEmployee(int id) {

        return entityManager.find(Employees.class, id);
    }

    @Override
    public Employees addEmployee(Employees employee) {
        Employees merge = entityManager.merge(employee);
        return merge;
    }

    @Override
    public void deleteById(int id) {
        Employees employees = entityManager.find(Employees.class, id);

        entityManager.remove(employees);

    }
}
