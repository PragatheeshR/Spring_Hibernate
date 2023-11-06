package com.praga.calculator.Calculator.controller;

import com.praga.calculator.Calculator.model.Calc;
import com.praga.calculator.Calculator.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class CalculatorController {

    private CalcService calcService;


    @Autowired
    public CalculatorController(CalcService calcService){
        this.calcService = calcService;
    }

    @GetMapping("/show")
    public String showForm(Model model){
        model.addAttribute("calcu",new Calc());
        return "show-form";
    }


    @GetMapping("/add")
    public String addNumbers(@ModelAttribute Calc calc, Model model){
        double val1 = calc.getFirstVal();
        double val2 = calc.getSecVal();

       double result =  calcService.addNumbers(val1,val2);
       calc.setResult(result);

       model.addAttribute("calcu",calc);

       return "show-form";


    }

}
