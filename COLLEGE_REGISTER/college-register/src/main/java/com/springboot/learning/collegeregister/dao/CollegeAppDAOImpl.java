package com.springboot.learning.collegeregister.dao;

import com.springboot.learning.collegeregister.entity.Course;
import com.springboot.learning.collegeregister.entity.Instructor;
import com.springboot.learning.collegeregister.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CollegeAppDAOImpl implements  CollegeAppDAO{

    EntityManager entityManager;

    public CollegeAppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void addNewCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public void addNewInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public void addCourseToStudent(Student student, List<Course> courses) {
        student.setCourses(courses);
        entityManager.merge(student);
    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }
}
