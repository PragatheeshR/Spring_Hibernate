package com.praga.springrestdemo.springdemo.rest;

import com.praga.springrestdemo.springdemo.error.StudentErrorResponse;
import com.praga.springrestdemo.springdemo.error.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> list;
    //define endpoint for /students

    @PostConstruct
    public void createdata(){
        list = new ArrayList<>();
        Student st1 = new Student("Pragatheesh","Raghu");
        Student st2 = new Student("Thanigai","Raghu");
        Student st3 = new Student("Megala","Arumugam");

        list.add(st1);
        list.add(st2);
        list.add(st3);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){

        return list;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId){

        if(studentId - 1 >= list.size() || studentId - 1 < 0){
                throw new StudentNotFoundException("Student Id not Found "+studentId);
        }

        return list.get(studentId - 1);
    }


}
