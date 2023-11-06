package com.praga.springdemo.springhibernateadvanced.dao;

import com.praga.springdemo.springhibernateadvanced.entity.Course;
import com.praga.springdemo.springhibernateadvanced.entity.Instructor;
import com.praga.springdemo.springhibernateadvanced.entity.InstructorDetail;
import com.praga.springdemo.springhibernateadvanced.entity.Review;

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
        for(Course course : instructor.getCourses()) {
        	course.setInstructor(null);
        }
        instructor.setCourses(null);
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
	public Instructor findInstructorByIdJoinFetch(int id) {
		TypedQuery<Instructor> createQuery = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses  where i.id = :data", Instructor.class);
		createQuery.setParameter("data", id);
		
		
		return createQuery.getSingleResult();
	}


	@Override

    @Transactional
	public void updateInstructor(Instructor instructor) {
		entityManager.merge(instructor);
		
	}


	@Override
	@Transactional
	public void updateCourse(Course course) {
		entityManager.merge(course);
		
		
	}


	@Override
	public Course findCourseById(int id) {
		return entityManager.find(Course.class, id);
	}


	@Override
	@Transactional
	public void deleteInstructor(int id) {
		 Instructor instructor =  entityManager.find(Instructor.class, id);
		 entityManager.remove(instructor);
		
	}


	@Override
	@Transactional
	public void deleteReviewById(int id) {
		Review review = entityManager.find(Review.class, id);
		review.setCourse(null);
		entityManager.remove(review);
		
	}


	@Override
	@Transactional
	public void deleteCourse(int id) {
		
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
		
	}
}
