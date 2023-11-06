package com.praga.springdemo.springhibernateadvanced.dao;

import com.praga.springdemo.springhibernateadvanced.entity.Course;
import com.praga.springdemo.springhibernateadvanced.entity.Instructor;
import com.praga.springdemo.springhibernateadvanced.entity.InstructorDetail;

import java.util.List;

public interface InstructorDAO {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteById(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructorDetailById(int id);

    public List<Course> findCoursesByInstId(int id);
    
    public Instructor findInstructorByIdJoinFetch(int id);
    
    public void updateInstructor(Instructor instructor);
    
    public void updateCourse(Course course);
    
    public Course findCourseById(int id);
    
    public void deleteInstructor(int id);
    
    public void deleteReviewById(int id);
    
    public void deleteCourse(int id);
}
