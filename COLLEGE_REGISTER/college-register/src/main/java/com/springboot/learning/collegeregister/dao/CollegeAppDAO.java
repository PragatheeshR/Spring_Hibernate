package com.springboot.learning.collegeregister.dao;

import com.springboot.learning.collegeregister.entity.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CollegeAppDAO {

    public void saveStudent(Student student);

    public void addNewCourse(Course course);

    public void addNewInstructor(Instructor instructor);

    public void addCourseToStudent(Student student, List<Course> course);

    public Student findStudentById(int id);

    public void addNewBook(Book book);

    public void addReview(Book book, Review review);

    public List<Student> findAllStudents();

    public List<Course> findAllCoursesForStudent(int id);


    public void addCourseToStudent(int stId, int courseId);

    public Course findCourseById(int id);
    public List<Course> findAllCourseSubscribed(int id);

    public void removeStudentCourse(int studentId, int courseId);

    public List<Course> getAllCourses();

    public void deleteCourse(int id);

    public List<Book> getUnsubscribedBooksForCourse(int courseId);

    public List<Book> getAllBooks();

    public void addBookToCourse(int courseId, int bookId);

    public Book findBookById(int id);






}
