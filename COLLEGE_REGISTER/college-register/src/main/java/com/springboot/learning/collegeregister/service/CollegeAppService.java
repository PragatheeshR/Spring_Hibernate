package com.springboot.learning.collegeregister.service;

import com.springboot.learning.collegeregister.dao.CollegeAppDAO;
import com.springboot.learning.collegeregister.entity.Book;
import com.springboot.learning.collegeregister.entity.Course;
import com.springboot.learning.collegeregister.entity.Review;
import com.springboot.learning.collegeregister.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeAppService {

    CollegeAppDAO collegeAppDAO;
    @Autowired
    MailService mailService;

    static String stdEnrollSubject = "Student Enrollment";
    static String courseEnrollSubject = "Course Enrollment";


    public CollegeAppService(CollegeAppDAO collegeAppDAO) {
        this.collegeAppDAO = collegeAppDAO;
    }

    public void saveStudent(Student student){

        collegeAppDAO.saveStudent(student);
        String receiverMailId = student.getEmail();
        String message = "Student "+student.getFirstName()+" is Enrolled in "+student.getDept();

        mailService.sendEmail(receiverMailId, stdEnrollSubject, message);
    }

    public void deleteStudent(int studentId){
        collegeAppDAO.deleteStudent(studentId);
    };

    public void saveNewCourse(Course course){
        collegeAppDAO.addNewCourse(course);
    }

    public Course findCourseById(int courseId){
        return collegeAppDAO.findCourseById(courseId);
    }

    public List<Student> findAllStudents(){
        return collegeAppDAO.findAllStudents();
    }

    public List<Course> findAllCoursesForStudent(int id){
       return collegeAppDAO.findAllCoursesForStudent(id);
    }

    public void addCourseToStudent(int stId, int courseId){
        collegeAppDAO.addCourseToStudent(stId, courseId);
        Student student = collegeAppDAO.findStudentById(stId);
        Course course = collegeAppDAO.findCourseById(courseId);

        String receiverMailId = student.getEmail();
        String message = "Student Name : "+student.getFirstName()+" \n\r" +
                         "Course Name  : "+course.getTitle()+" \n\r"+
                         "Instructor   :"+course.getAuthor()+"\n\r"+
                         "Books For Ref :"+course.getBooks();
        mailService.sendEmail(receiverMailId,courseEnrollSubject,message);

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

    public List<Review> addReviewForBookId(Review review, int bookId){
        return collegeAppDAO.addReviewForBookId(review, bookId);
    }

    public List<Review> getReviewForBookId(int bookId){
        return collegeAppDAO.getAllReviewForBook(bookId);
    }

    public List<Book> showSubBook(int courseId){
        return collegeAppDAO.showSubBook(courseId);
    }

    public void deleteSubBooks(int courseId, int bookId){
        collegeAppDAO.deleteSubCourse(courseId, bookId);
    }



}
