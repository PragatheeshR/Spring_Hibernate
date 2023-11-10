package com.springboot.learning.collegeregister.service;

import com.springboot.learning.collegeregister.dao.CollegeAppDAO;
import com.springboot.learning.collegeregister.entity.Course;
import com.springboot.learning.collegeregister.entity.Student;
import org.springframework.stereotype.Service;

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
}
