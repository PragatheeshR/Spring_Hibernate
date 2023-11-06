package com.praga.springdemo.springhibernateadvanced;

import com.praga.springdemo.springhibernateadvanced.dao.InstructorDAO;
import com.praga.springdemo.springhibernateadvanced.dao.InstructorDAOImpl;
import com.praga.springdemo.springhibernateadvanced.entity.Course;
import com.praga.springdemo.springhibernateadvanced.entity.Instructor;
import com.praga.springdemo.springhibernateadvanced.entity.InstructorDetail;
import com.praga.springdemo.springhibernateadvanced.entity.Review;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringHibernateAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateAdvancedApplication.class, args);
	}


	@Bean
	public  CommandLineRunner commandLineRunner(InstructorDAO instructorDAO){
		return runner -> {
			//createInstructor(instructorDAO);
			//findInstructor(1, instructorDAO);
			//deleteInstructor(1, instructorDAO);
			//findInstructorDetail(2, instructorDAO);
			//deleteInstructordetailById(3, instructorDAO);
			//getCoursesWithInstructorLazy(instructorDAO);
			//findInstWithCoursesFETCH(instructorDAO);
			//updateInstructorById(1, instructorDAO);
			//udpateCoursebyId(10, instructorDAO);
			//deleteInstructor(1, instructorDAO);
			//deleteReviewbyId(1, instructorDAO);
			deleteCourse(10, instructorDAO);
			

		};

	}
	
	private void deleteCourse(int id, InstructorDAO dao) {
		dao.deleteCourse(id);
	}
	
	private void deleteReviewbyId(int id, InstructorDAO instructorDAO) {
		instructorDAO.deleteReviewById(id);
	}
	
	private void udpateCoursebyId(int id, InstructorDAO dao) {
		Course course = dao.findCourseById(id);
		course.setTitle("New Program data for sys");
		dao.updateCourse(course);
	}
	
	private void updateInstructorById(int id, InstructorDAO dao) {
		
		Instructor instructor = dao.findById(id);
		instructor.setEmail("pragatheesh1584@gmail.com");
		instructor.setLastName("Raghunath");
		dao.updateInstructor(instructor);
	}
	
	private void findInstWithCoursesFETCH(InstructorDAO instructorDAO) {
		int id = 1;
		Instructor instructor = instructorDAO.findInstructorByIdJoinFetch(id);
		
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
		
		
	}

	private void getCoursesWithInstructorLazy(InstructorDAO instructorDAO){
		int id = 1;
		Instructor instructor = instructorDAO.findById(1);

		List<Course> courses = instructorDAO.findCoursesByInstId(id);

		instructor.setCourses(courses);

		System.out.println(instructor.getCourses());
	}

	private void deleteInstructordetailById(int id, InstructorDAO instructorDAO) {
		instructorDAO.deleteInstructorDetailById(id);
		System.out.println("Deleted");
	}

	private void deleteInstructor(int id, InstructorDAO instructorDAO) {
		instructorDAO.deleteById(id);
		System.out.println("Deleted");
	}

	private void findInstructor(int id, InstructorDAO instructorDAO) {

		Instructor instructor = instructorDAO.findById(id);

		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
		System.out.println(instructor.getCourses());

	}

	private void createInstructor(InstructorDAO instructorDAO){

		Instructor instructor = new Instructor("Pragatheesh", "Raghu","praga.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.udemy.com/course/spring-hibernate-tutorial/learn/lecture/37877804#questions", "Coding");

		Review review = new Review("Good");
		Review review2 = new Review("Better");
		
//		List<Review> reviewList = new ArrayList<>();
//		reviewList.add(review);		
//		reviewList.add(review2);
		
		List<Course> list = new ArrayList<>();
		Course course = new Course("Java made easy");
		course.addReview(review);
		course.addReview(review2);
		
		Review review3 = new Review("New Learning");
		Review review4 = new Review("Better to relate");
		
		Course course2 = new Course("New Python");
		course2.addReview(review3);
		course2.addReview(review4);

		list.add(course);
		list.add(course2);

		instructor.setInstructorDetail(instructorDetail);
		instructor.add(list);

		instructorDAO.save(instructor);
		System.out.println("Data Created");
	}

	private void findInstructorDetail(int id, InstructorDAO instructorDAO){
		InstructorDetail instructorDetail = instructorDAO.findInstructorDetailById(id);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}
	
	

}
