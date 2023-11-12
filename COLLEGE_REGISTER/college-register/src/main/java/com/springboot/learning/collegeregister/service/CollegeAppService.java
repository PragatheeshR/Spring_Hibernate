package com.springboot.learning.collegeregister.service;

import com.springboot.learning.collegeregister.dao.CollegeAppDAO;
import com.springboot.learning.collegeregister.entity.Book;
import com.springboot.learning.collegeregister.entity.Course;
import com.springboot.learning.collegeregister.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CollegeAppService {

    CollegeAppDAO collegeAppDAO;

    public CollegeAppService(CollegeAppDAO collegeAppDAO) {
        this.collegeAppDAO = collegeAppDAO;
    }

    public void saveStudent(Student student){
        collegeAppDAO.saveStudent(student);
    }

    public void saveNewCourse(Course course){
        collegeAppDAO.addNewCourse(course);
    }

    public List<Student> findAllStudents(){
        return collegeAppDAO.findAllStudents();
    }

    public List<Course> findAllCoursesForStudent(int id){
       return collegeAppDAO.findAllCoursesForStudent(id);
    }

    public void addCourseToStudent(int stId, int courseId){
        collegeAppDAO.addCourseToStudent(stId, courseId);
    }

    public List<Course> findAllCourseSubscribed(int id){
        return collegeAppDAO.findAllCourseSubscribed(id);
    }

    public void removeStudentCourse(int studentId, int courseId){
        collegeAppDAO.removeStudentCourse(studentId, courseId);
    }


    public List<Course> getAllCourses(){
        return collegeAppDAO.getAllCourses();
    };

    public void addNewBook(Book book){
        collegeAppDAO.addNewBook(book);
    }

    public void deleteCourse(int id){
        collegeAppDAO.deleteCourse(id);
    }

    public List<Book> getUnsubscribedBooksForCourse(int courseId){
        return collegeAppDAO.getUnsubscribedBooksForCourse(courseId);
    }

    public void addBookToCourse(int courseId, int bookId){
            collegeAppDAO.addBookToCourse(courseId, bookId);
    }

    public List<Book> getAllBooks(){
        return collegeAppDAO.getAllBooks();
    }




}
