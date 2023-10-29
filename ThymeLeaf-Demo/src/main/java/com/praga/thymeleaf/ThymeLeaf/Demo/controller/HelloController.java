package com.praga.thymeleaf.ThymeLeaf.Demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // to show basic html page.
    //@RequestMapping("/show")
    @GetMapping("/show")
    public String showForm(){
        return "helloForm";
    }

    @RequestMapping("/view")
    public String viewPage(){
        return "filledForm";
    }

    @RequestMapping("/capsview")
    public String viewCapsPage(HttpServletRequest request, Model model){
        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        model.addAttribute("message", name);
        return "filledForm";
    }

    //@RequestMapping("/capsviewV2")
    @GetMapping("/capsviewV2")
    public String viewCapsPageWithReqParam(@RequestParam("studentName") String name, Model model){
        name = name.toUpperCase();
        model.addAttribute("message", name);
        return "filledForm";
    }
}
