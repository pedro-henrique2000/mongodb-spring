package com.mongodb.mongo_spring.service;

import com.mongodb.mongo_spring.model.Student;

public interface SearchStudentInbond {
    Student find(String value);
}
