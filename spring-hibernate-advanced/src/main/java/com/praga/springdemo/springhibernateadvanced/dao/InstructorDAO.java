package com.praga.springdemo.springhibernateadvanced.dao;

import com.praga.springdemo.springhibernateadvanced.entity.Instructor;
import com.praga.springdemo.springhibernateadvanced.entity.InstructorDetail;

public interface InstructorDAO {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteById(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructorDetailById(int id);
}
