package com.springboot.learning.collegeregister.controller;

import com.springboot.learning.collegeregister.entity.*;
import com.springboot.learning.collegeregister.service.CollegeAppService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/college")
public class AppController {

    private CollegeAppService collegeAppService;

    public AppController(CollegeAppService collegeAppService) {
        this.collegeAppService = collegeAppService;
    }


    @GetMapping("/homepage")
    public String homePage(Model model) {

        List<Student> studentList = collegeAppService.findAllStudents();
        model.addAttribute("students", studentList);
        if(model.containsAttribute("check")){
            System.out.println("YESSSS");
        }

        return "home-page";
    }

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {
        Student student = new Student();
        StudentDetail studentDetail = new StudentDetail();
        student.setStudentDetail(studentDetail);
        model.addAttribute("student", student);
        return "student-form";
    }

    @GetMapping("/showCourseForm")
    public String showCourseForm(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "course-form";
    }


    @PostMapping("/processForm")
    public String processForm(@ModelAttribute Student student) {
        System.out.println(student);
        System.out.println(student.getStudentDetail());
        collegeAppService.saveStudent(student);
        return "redirect:/college/homepage";
    }

    @PostMapping("/processCourseForm")
    public String processCourseForm(@ModelAttribute Course course) {
        collegeAppService.saveNewCourse(course);
        System.out.println("Added data to DB");
        return "redirect:/college/homepage";
    }

    @GetMapping("/showAllCourses/")
    public String showAllCourses(@RequestParam("stdId") int id, Model model) {
        List<Course> courseList = collegeAppService.findAllCoursesForStudent(id);
        model.addAttribute("courses", courseList);
        model.addAttribute("stdId", id);
        model.addAttribute("addCourse", "addData");
        return "show-courses";
    }

    @GetMapping("/addCourse/")
    public String addCourse(@RequestParam("studentId") int studentId, @RequestParam("courseId") int courseId, RedirectAttributes redirectAttributes) {
        collegeAppService.addCourseToStudent(studentId, courseId);

        redirectAttributes.addAttribute("stdId", studentId);

        return "redirect:/college/showAllCourses/?stdId={stdId}";
    }

    @GetMapping("/showMyCourse/")
    public String showStudentCourses(@RequestParam("studentId") int id, Model model) {
        List<Course> courseList = collegeAppService.findAllCourseSubscribed(id);
        model.addAttribute("courses", courseList);
        model.addAttribute("stdId", id);
        model.addAttribute("check", "valid");
        if(courseList == null || courseList.isEmpty()){
            return "redirect:/college/homepage";
        }
        return "show-courses";
    }

    @GetMapping("/deleteCourse/")
    public String deleteStudentCourse(@RequestParam("studentId") int studentId, @RequestParam("courseId") int courseId, RedirectAttributes redirectAttributes) {
        collegeAppService.removeStudentCourse(studentId, courseId);
        redirectAttributes.addAttribute("studentId", studentId);
        return "redirect:/college/showMyCourse/?studentId={studentId}";
    }

    @GetMapping("/showCourses")
    public String getAllCourses(Model model) {
        List<Course> courseList = collegeAppService.getAllCourses();
        model.addAttribute("courses", courseList);
        return "show-all-courses";
    }

    @GetMapping("/removeCourse/")
    public String removeCourseFromRegister(@RequestParam("courseId") int courseId) {
        collegeAppService.deleteCourse(courseId);
        return "redirect:/college/showCourses";
    }

    @GetMapping("/showBookForm")
    public String addBook(Model model) {
        Book book = new Book();
        List<Book> books = collegeAppService.getAllBooks();
        model.addAttribute("book", book);
        model.addAttribute("books", books);
        return "book-form";
    }

    @PostMapping("/processBookForm")
    public String addNewBook(@ModelAttribute Book book) {
        book.setAvailable(true);
        collegeAppService.addNewBook(book);

        return "redirect:/college/showBookForm";
    }

    @GetMapping("/showBooks/")
    public String getUnsubscribedBooksForCourse(@RequestParam("courseId") int courseId, Model model) {
        List<Book> books = collegeAppService.getUnsubscribedBooksForCourse(courseId);
        System.out.println(books);
        model.addAttribute("books", books);
        model.addAttribute("courseId", courseId);
        return "show-books";
    }

    @GetMapping("/addBook/")
    public String addBookToCourse(@RequestParam("courseId") int courseId, @RequestParam("bookId") int bookId, RedirectAttributes redirectAttributes) {

        collegeAppService.addBookToCourse(courseId, bookId);
        redirectAttributes.addAttribute("courseId", courseId);
        return "redirect:/college/showBooks/?courseId={courseId}";
    }

    @GetMapping("/showAllBooks")
    public String getAllBooks(Model model) {
        List<Book> books = collegeAppService.getAllBooks();
        model.addAttribute("books", books);

        return "show-all-books";
    }


    @GetMapping("/showReviewForm/")
    public String showReviewForm(Model model, @RequestParam("bookId") int bookId) {
        Review review = new Review();
        model.addAttribute("review", review);
        model.addAttribute("bookId", bookId);
        List<Review> reviewList = collegeAppService.getReviewForBookId(bookId);
        model.addAttribute("reviews", reviewList);

        return "review-form";
    }

    @PostMapping("/processReviewForm/")
    public String addReview(@ModelAttribute Review review, @RequestParam("bookId") int bookId, RedirectAttributes redirectAttributes) {
        List<Review> reviewList = collegeAppService.addReviewForBookId(review, bookId);
        redirectAttributes.addAttribute("bookId", bookId);
        return "redirect:/college/showReviewForm/?bookId={bookId}";
    }

    @GetMapping("/showSubBooks/")
    public String showSubBooks(Model model, @RequestParam("courseId") int courseId) {
        List<Book> bookList = collegeAppService.showSubBook(courseId);
        model.addAttribute("books", bookList);
        return "show-sub-books";
    }

    @GetMapping("/deleteSubCourse/")
    public String deleteSubCourse(@RequestParam("courseId") int courseId, @RequestParam("studentId") int studentId, RedirectAttributes redirectAttributes) {
        collegeAppService.deleteSubBooks(courseId, studentId);
        redirectAttributes.addAttribute("studentId", studentId);
        return "redirect:/college/showMyCourse/?studentId={studentId}";

    }
}
