package com.praga.springdemo.springhibernateadvanced.dao;

import com.praga.springdemo.springhibernateadvanced.entity.Course;
import com.praga.springdemo.springhibernateadvanced.entity.Instructor;
import com.praga.springdemo.springhibernateadvanced.entity.InstructorDetail;
import com.praga.springdemo.springhibernateadvanced.entity.Student;

import java.util.List;

public interface InstructorDAO {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteById(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructorDetailById(int id);

    public List<Course> findCoursesByInstId(int id);

    public void saveStudent(Course student);

    public void findStudentById(int id);

    public Course findCourseByName(String courseName);

   void deleteStudentById(int id);
}
