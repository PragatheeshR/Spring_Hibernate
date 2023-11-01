package com.praga.springdemo.springhibernateadvanced;

import com.praga.springdemo.springhibernateadvanced.dao.InstructorDAO;
import com.praga.springdemo.springhibernateadvanced.dao.InstructorDAOImpl;
import com.praga.springdemo.springhibernateadvanced.entity.Course;
import com.praga.springdemo.springhibernateadvanced.entity.Instructor;
import com.praga.springdemo.springhibernateadvanced.entity.InstructorDetail;
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
			getCoursesWithInstructorLazy(instructorDAO);

		};

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


		List<Course> list = new ArrayList<>();
		list.add(new Course("Java made easy"));
		list.add(new Course("New Python"));
		list.add(new Course("Maven"));
		list.add(new Course("System Design"));

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
