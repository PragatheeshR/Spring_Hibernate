package com.springboot.learning.collegeregister.dao;

import com.springboot.learning.collegeregister.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    @Transactional
    public void addNewBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void addReview(Book book, Review review) {
        book.setReviews(review);
        addNewBook(book);
    }

    @Override
    public List<Student> findAllStudents() {
        TypedQuery<Student> studentTypedQuery =  entityManager.createQuery("from Student", Student.class);
        return studentTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public List<Course> findAllCoursesForStudent(int id) {
        Student student = entityManager.find(Student.class, id);
        List<Course> courseList = entityManager.createQuery("from Course", Course.class).getResultList();
        List<Course> nonAddedCourseList = new ArrayList<>();

        if(student.getCourses() == null || student.getCourses().isEmpty()){
            return courseList;
        }

        for(Course course : courseList){
            if(!student.getCourses().contains(course)){
                nonAddedCourseList.add(course);
            }
        }

        return nonAddedCourseList;
    }

    @Override
    public Course findCourseById(int id){
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> findAllCourseSubscribed(int id) {
        Student student = findStudentById(id);

        return student.getCourses();
    }

    @Override
    @Transactional
    public void removeStudentCourse(int studentId, int courseId) {

        Course course = findCourseById(courseId);
        Student student = findStudentById(studentId);
        student.getCourses().remove(course);
        entityManager.merge(student);

    }

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course course = findCourseById(id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public List<Book> getUnsubscribedBooksForCourse(int courseId) {
        Course course = findCourseById(courseId);
        List<Book> bookList = getAllBooks();
        System.out.println("in DB Layer "+bookList);

        if(course.getBooks() == null || course.getBooks().isEmpty()){
            return bookList;
        }
        else {
            List<Book> unsubscribedBooks = new ArrayList<>();
            List<Book> subscribedBooks = course.getBooks();
            for(Book book : bookList){
                if(!subscribedBooks.contains(book)){
                    unsubscribedBooks.add(book);
                }
            }
            return unsubscribedBooks;
        }

    }

    @Override
    public List<Book> getAllBooks() {
        return entityManager.createQuery("from Book", Book.class).getResultList();
    }

    @Override
    @Transactional
    public void addBookToCourse(int courseId, int bookId) {
            Course course = findCourseById(courseId);
            Book book = findBookById(bookId);

            book.setCourse(course);
            entityManager.merge(book);
    }

    @Override
    public Book findBookById(int id) {
        return entityManager.find(Book.class, id);
    }


    @Override
    @Transactional
    public void addCourseToStudent(int stId, int courseId) {
        Student student = findStudentById(stId);
        Course course = findCourseById(courseId);

        student.getCourses().add(course);
        entityManager.merge(student);

    }


}
