package com.example.springsecuritycustom.service;

import com.example.springsecuritycustom.repositories.StudentRepository;
import com.example.springsecuritycustom.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentRegistrationService {

    private final StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public StudentRegistrationService( StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addNewStudent( Student student, List<String> authorities ) {

        student.addAuthorityToUser(authorities);

        String password = student.getPassword();
        student.setPassword(bCryptPasswordEncoder.encode(password));

        studentRepository.save(student);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
