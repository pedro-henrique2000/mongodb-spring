package com.mongodb.mongo_spring.repository;

import com.mongodb.mongo_spring.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByEmail(String email);

    List<Student> findByTotalSpentInBooksGreaterThan(BigDecimal totalSpent);

    @Query(value = " { 'firstName': ?0 } ", fields = "{'firstName' : 1, 'totalSpentInBooks': 1}")
    List<Student> findByFirstName(String firstName);

    @Query(value = " { 'favoriteSubjects': {$size: ?0} } ")
    List<Student> findByFavoriteSubjectsSize(int size);
}