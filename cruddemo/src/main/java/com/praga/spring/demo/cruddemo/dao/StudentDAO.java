package com.praga.spring.demo.cruddemo.dao;

import com.praga.spring.demo.cruddemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDAO {

    public void save(Student student);

    public Student getRecord(int id);

    public List<Student> findbyLastName(String lastname);
    public void updateLastName(String lastname);

    public int deletebyLastName(String lastName);
}
