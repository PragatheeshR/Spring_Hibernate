package com.springboot.learning.collegeregister.controller;

import com.springboot.learning.collegeregister.entity.Course;
import com.springboot.learning.collegeregister.entity.Student;
import com.springboot.learning.collegeregister.entity.StudentDetail;
import com.springboot.learning.collegeregister.service.CollegeAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/college")
public class AppController {

    private CollegeAppService collegeAppService;

    public AppController(CollegeAppService collegeAppService) {
        this.collegeAppService = collegeAppService;
    }


    @GetMapping("/homepage")
    public String homePage(){
        return "home-page";
    }

    @GetMapping("/showStudentForm")
    public String showForm(Model model){
        Student student = new Student();
        StudentDetail studentDetail = new StudentDetail();
        student.setStudentDetail(studentDetail);
        model.addAttribute("student", student);
        return "student-form";
    }

    @GetMapping("/showCourseForm")
    public String showCourseForm(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "course-form";
    }



    @PostMapping("/processForm")
    public String processForm(@ModelAttribute Student student){
        System.out.println(student);
        System.out.println(student.getStudentDetail());
        collegeAppService.saveStudent(student);
        return "redirect:/";
    }

    @PostMapping("/processCourseForm")
    public String processCourseForm(@ModelAttribute Course course){
        collegeAppService.saveNewCourse(course);
        return "course-form";
    }
}
