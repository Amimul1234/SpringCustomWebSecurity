package com.example.springsecuritycustom.controller;

import com.example.springsecuritycustom.entity.Student;
import com.example.springsecuritycustom.service.StudentRegistrationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentRegistrationController
{
    private final StudentRegistrationService studentRegistrationService;

    public StudentRegistrationController( StudentRegistrationService studentRegistrationService ) {
        this.studentRegistrationService = studentRegistrationService;
    }

    @PostMapping("/registerNewStudent")
    public void addNewStudent( @RequestBody Student student,
                               @RequestParam("authorities")List<String> authorities)
    {
        studentRegistrationService.addNewStudent(student, authorities);
    }

    @GetMapping("/getWelcomeMessage")
    public String getWelcomeMessage()
    {
        return "Hello This is spring security from mongodb";
    }
}
