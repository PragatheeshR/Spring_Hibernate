package com.praga.springdemo.springhibernateadvanced.dao;

import com.praga.springdemo.springhibernateadvanced.entity.Course;
import com.praga.springdemo.springhibernateadvanced.entity.Instructor;
import com.praga.springdemo.springhibernateadvanced.entity.InstructorDetail;
import com.praga.springdemo.springhibernateadvanced.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorDAOImpl implements InstructorDAO{

    private EntityManager entityManager;

    @Autowired
    public InstructorDAOImpl(EntityManager entityManager){
        this.entityManager =entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
        //return null;
    }

    @Override
    public Instructor findById(int id) {
       Instructor instructor = entityManager.find(Instructor.class, id);
       return instructor;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {

        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        return instructorDetail;


    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);

    }

    @Override
    public List<Course> findCoursesByInstId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);
        List<Course> resultList = query.getResultList();

        return resultList;
    }

    @Override
    @Transactional
    public void saveStudent(Course student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void findStudentById(int id){
        Student student = entityManager.find(Student.class, id);
        Course course = findCourseByName("Temp");
        course.addStudent(student);
        entityManager.merge(course);
        //return entityManager.find(Student.class, id);

    }

    @Override
    public Course findCourseByName(String courseName) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where title = :data", Course.class);
        query.setParameter("data", courseName);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        //TypedQuery<Student> query = entityManager.createQuery("from Student where id = :data", Student.class);
       // query.setParameter("data", id);
        Student student = entityManager.find(Student.class, id);
       // student.getCourses().clear();
        entityManager.remove(student);

    }
}
