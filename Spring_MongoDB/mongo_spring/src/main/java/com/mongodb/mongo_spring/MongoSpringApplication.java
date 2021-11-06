package com.mongodb.mongo_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoSpringApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(StudentRepository repository, MongoTemplate template) {
//        return args -> {
//
//            String email = "pedro1234@teste.com";
//
//            Student student = new Student("Pedro", "Henrique", email, Gender.MALE,
//                    new Address("BR", "SL", "123"), Arrays.asList("Math", "Geo"),
//                    BigDecimal.TEN, LocalDateTime.now());
//
//            repository.findStudentByEmail(email).ifPresentOrElse((s) -> {
//                throw new IllegalArgumentException("Student already registered with that email!");
//            }, () -> {
//                repository.insert(student);
//                System.out.println(student + " created!");
//            });
//
//
//        };
//    }

//    Query query = new Query();
//            query.addCriteria(Criteria.where("email").is(email));
//
//            List<Student> list = template.find(query, Student.class);
//
//            if (list.size() > 1) {
//            }
//            if (list.isEmpty()){
//                repository.save(student);
//                System.out.println("\nCreated: " + student);
//            } else{
//                System.out.println(student + " already exists");
//            }

}
