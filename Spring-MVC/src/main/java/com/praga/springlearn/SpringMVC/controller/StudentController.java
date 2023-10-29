package com.praga.springlearn.SpringMVC.controller;

import com.praga.springlearn.SpringMVC.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${lang}")
    private List<String> lang;

    @GetMapping("/show")
    public String showForm(Model model){

        model.addAttribute("student", new Student());
        model.addAttribute("countries", countries);
        model.addAttribute("lang", lang);

        return "student-form";
    }

    @PostMapping("/processForm")
    public String processedForm(@ModelAttribute("student") Student student){
        System.out.println("Student is Confirmed "+student.toString() +student.getCountry());
        return "process-form";
    }
}
