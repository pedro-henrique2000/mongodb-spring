package com.mongodb.mongo_spring.service;

import com.mongodb.mongo_spring.model.SearchRequest;
import com.mongodb.mongo_spring.repository.StudentRepository;
import com.mongodb.mongo_spring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getByEmail(String email) {
        return studentRepository.findStudentByEmail(email).orElseThrow(() ->
                new IllegalArgumentException("Not found exception"));
    }

    public List<Student> totalSpentBiggerThan(BigDecimal bigDecimal) {
        return studentRepository.findByTotalSpentInBooksGreaterThan(bigDecimal);
    }

    public List<Student> studentsByFirstName(String name) {
        return studentRepository.findByFirstName(name);
    }

    public List<Student> findByFavorites(Integer size) {
        return studentRepository.findByFavoriteSubjectsSize(size);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public Student update(String id) {
        Student student = studentRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        student.setFirstName("Updated - " + student.getFirstName());

        return studentRepository.save(student);
    }


}
