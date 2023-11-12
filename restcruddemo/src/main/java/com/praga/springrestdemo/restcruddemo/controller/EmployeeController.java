package com.praga.springrestdemo.restcruddemo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.praga.springrestdemo.restcruddemo.entity.Employees;
import com.praga.springrestdemo.restcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService){
        System.out.println("created Emp Controller");
        this.employeeService = employeeService;
    }


    // to get all emp details
    @GetMapping("/employees")
    public List<Employees> getStudents(){
            return employeeService.getStudents();
    }

    //to get a particular emp details
    @GetMapping("/employees/{empID}")
    public Employees getStudents(@PathVariable int empID){
        return employeeService.getStudent(empID);
    }

    //public api to check how it works
    @GetMapping("/public")
    public Object getRandom(){
        String uri = "https://v2.jokeapi.dev/joke/Any?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single";
        RestTemplate restTemplate = new RestTemplate();
        Object result =  restTemplate.getForObject(uri,Object.class);
        // Parse JSON using Jackson
        /*ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert JSON string to JsonNode
            JsonNode jsonNode = objectMapper.readTree(result);

            // Extract a particular key-value pair
           // result = jsonNode.get("hourly_units").toString();
            //int userId = jsonNode.get("userId").asInt();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


        return result;
    }

    //to add new Employee
    @PostMapping("/employee")
    public Employees addnewEmployee(@RequestBody Employees employee){

        return  employeeService.addNewStudent(employee);
    }

    //to delete an employee
    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }

}
