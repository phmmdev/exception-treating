package com.exception.treatment.demo.student;

import com.exception.treatment.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents()
    {
        throw new ApiRequestException("Error loading students!! From custom Exception");
       // return studentService.getAllStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
    }
}
