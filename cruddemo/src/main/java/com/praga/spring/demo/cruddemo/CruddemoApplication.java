package com.praga.spring.demo.cruddemo;

import com.praga.spring.demo.cruddemo.dao.StudentDAO;
import com.praga.spring.demo.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean // dont forget to add this annotation
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			 addNewRecord(studentDAO);
			//findbyLastName(studentDAO);
			//updateLastName(studentDAO);
			//deletebyLastName(studentDAO);
		};
	}

	private void deletebyLastName(StudentDAO studentDAO) {

		int rec = studentDAO.deletebyLastName("aru");
		System.out.println("Deleted "+rec+" records");

	}

	private void updateLastName(StudentDAO studentDAO) {
		studentDAO.updateLastName("raghu");
		findbyLastName(studentDAO);

	}

	private void addNewRecord(StudentDAO studentDAO){
		Student student = new Student("Pragatheesh", "raghu", "praga.com");
		Student student2 = new Student("Thanigai", "raghu", "thani.com");
		Student student3 = new Student("Megala", "aru", "megala.com");

		studentDAO.save(student);
		studentDAO.save(student2);
		studentDAO.save(student3);
		//System.out.println("Successfully created a record");

		//System.out.println(studentDAO.getRecord(6));

	}

	private void findbyLastName(StudentDAO studentDAO){
		List<Student> info = studentDAO.findbyLastName("Mariot");

		info.stream().forEach(System.out::println);

	}

}
