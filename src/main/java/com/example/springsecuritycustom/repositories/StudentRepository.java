package com.example.springsecuritycustom.repositories;

import com.example.springsecuritycustom.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface StudentRepository extends MongoRepository<Student, String> {
    UserDetails findByEmail(String username);
}
