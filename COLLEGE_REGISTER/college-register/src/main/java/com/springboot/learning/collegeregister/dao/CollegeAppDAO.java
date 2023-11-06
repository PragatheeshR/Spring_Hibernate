package com.springboot.learning.collegeregister.dao;

import com.springboot.learning.collegeregister.entity.Course;
import com.springboot.learning.collegeregister.entity.Instructor;
import com.springboot.learning.collegeregister.entity.Student;

import java.util.List;

public interface CollegeAppDAO {

    public void saveStudent(Student student);

    public void addNewCourse(Course course);

    public void addNewInstructor(Instructor instructor);

    public void addCourseToStudent(Student student, List<Course> course);

    public Student findStudentById(int id);



}
