package com.exception.treatment.demo.student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentDataAccessService {

    public List<Student> getAllStudents() {
        List<Student> studentList =  new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            studentList.add(new Student(UUID.randomUUID(), UUID.randomUUID().toString()));
        }

        return studentList;
    }
}
