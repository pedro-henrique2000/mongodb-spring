package com.mongodb.mongo_spring.controller;

import com.mongodb.mongo_spring.model.SearchRequest;
import com.mongodb.mongo_spring.model.Student;
import com.mongodb.mongo_spring.service.SearchStudentInbond;
import com.mongodb.mongo_spring.service.StudentService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private BeanFactory beanFactory;

    @GetMapping()
    public List<Student> fetchAllStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student postStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("{email}")
    public Student getByEmail(@PathVariable String email) {
        return studentService.getByEmail(email);
    }

    @GetMapping("/total/{total}")
    public List<Student> getByEmail(@PathVariable BigDecimal total) {
        return studentService.totalSpentBiggerThan(total);
    }

    @GetMapping("/search")
    public Student searchStudent(@RequestBody SearchRequest searchRequest) {
        return beanFactory.getBean(searchRequest.getType().getName(), SearchStudentInbond.class).find(searchRequest.getValue());
    }

    @GetMapping("/name/{name}")
    public List<Student> getByName(@PathVariable String name) {
        return studentService.studentsByFirstName(name);
    }

    @GetMapping("/size/{size}")
    public List<Student> getByFavoritesSize(@PathVariable int size) {
        return studentService.findByFavorites(size);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable String id) {
        return studentService.update(id);
    }

}
