package com.mongodb.mongo_spring.service;

import com.mongodb.mongo_spring.model.Student;
import com.mongodb.mongo_spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "searchById")
public class SearchById implements SearchStudentInbond {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student find(String value) {
        return studentRepository.findById(value).get();
    }
}
